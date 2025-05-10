package com.albanda.gamerapp.domain.repository

import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.domain.model.User

interface UserRepository {

    suspend fun createUser(user: User): Response<Boolean>

}