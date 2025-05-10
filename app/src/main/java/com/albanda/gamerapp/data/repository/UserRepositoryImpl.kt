package com.albanda.gamerapp.data.repository

import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.domain.model.User
import com.albanda.gamerapp.domain.repository.UserRepository
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val usersRef: CollectionReference): UserRepository {

    override suspend fun createUser(user: User): Response<Boolean> {
        return try {
            usersRef.document(user.id).set(user).await()
            Response.Success(true)
        } catch (e: Exception) {
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}