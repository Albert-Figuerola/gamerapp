package com.albanda.gamerapp.domain.repository

import com.albanda.gamerapp.domain.model.Response
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    val currentUser: FirebaseUser?
    suspend fun login(email: String, password: String): Response<FirebaseUser>
    fun logout()
}