package com.albanda.gamerapp.data.repository.post

import android.net.Uri
import com.albanda.gamerapp.core.Constants.POSTS
import com.albanda.gamerapp.core.Constants.USERS
import com.albanda.gamerapp.domain.model.Post
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.domain.model.User
import com.albanda.gamerapp.domain.repository.PostRepository
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.storage.StorageReference
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.io.File
import javax.inject.Inject
import javax.inject.Named

class PostRepositoryImpl @Inject constructor(
    @Named(POSTS) private val postsRef: CollectionReference,
    @Named(USERS) private val usersRef: CollectionReference,
    @Named(POSTS) private val storagePostsRef: StorageReference,
) : PostRepository {

    override suspend fun createPost(
        post: Post,
        file: File
    ): Response<Boolean> {
        return try {
            val fromFile = Uri.fromFile(file)
            val ref = storagePostsRef.child(file.name)
            ref.putFile(fromFile).await()
            val url = ref.downloadUrl.await()

            post.image = url.toString()
            postsRef.add(post).await()

            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun getPosts(): Flow<Response<List<Post>>> = callbackFlow {
        val snapshotListener = postsRef.addSnapshotListener { snapshot, e ->
            GlobalScope.launch(Dispatchers.IO) {
                val postsResponse = if (snapshot != null) {
                    val posts = snapshot.toObjects(Post::class.java)

                    val userIds = posts.map { it.userId }.distinct()

                    userIds.map { userId ->
                        async {
                            val user = usersRef.document(userId).get().await().toObject(User::class.java)!!
                            posts.forEach { post ->
                                if (post.userId == userId) {
                                    post.user = user
                                }
                            }
                        }
                    }.forEach {
                        it.await()
                    }
                    Response.Success(posts)
                } else {
                    Response.Failure(e)
                }
                trySend(postsResponse)
            }

        }
        awaitClose {
            snapshotListener.remove()
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun getPostsByUserId(userId: String): Flow<Response<List<Post>>> = callbackFlow {
        val snapshotListener = postsRef.whereEqualTo("userId", userId).addSnapshotListener { snapshot, e ->
            val postsResponse = if (snapshot != null) {
                val posts = snapshot.toObjects(Post::class.java)

                Response.Success(posts)
            } else {
                Response.Failure(e)
            }
            trySend(postsResponse)
        }
        awaitClose {
            snapshotListener.remove()
        }
    }
}