package com.albanda.gamerapp.domain.repository

import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun createUser(user: User): Response<Boolean>

    suspend fun updateUser(user: User): Response<Boolean>

    fun getUserById(userId: String): Flow<User>

}