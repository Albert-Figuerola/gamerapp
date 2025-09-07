package com.albanda.gamerapp.domain.repository

import com.albanda.gamerapp.domain.model.Post
import com.albanda.gamerapp.domain.model.Response
import kotlinx.coroutines.flow.Flow
import java.io.File

interface PostRepository {

    suspend fun createPost(post: Post, file: File): Response<Boolean>

    fun getPosts(): Flow<Response<List<Post>>>

    fun getPostsByUserId(userId: String): Flow<Response<List<Post>>>

    suspend fun deletePost(postId: String): Response<Boolean>

}