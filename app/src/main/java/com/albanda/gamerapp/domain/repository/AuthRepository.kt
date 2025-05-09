package com.albanda.gamerapp.domain.repository

import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.domain.model.User
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    val currentUser: FirebaseUser?

    suspend fun login(email: String, password: String): Response<FirebaseUser>
    suspend fun signUp(user: User): Response<FirebaseUser>

    fun logout()


}