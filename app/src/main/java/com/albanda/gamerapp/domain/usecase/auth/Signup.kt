package com.albanda.gamerapp.domain.usecase.auth

import com.albanda.gamerapp.domain.model.User
import com.albanda.gamerapp.domain.repository.AuthRepository
import javax.inject.Inject


class Signup @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(user: User) = authRepository.signUp(user)
}