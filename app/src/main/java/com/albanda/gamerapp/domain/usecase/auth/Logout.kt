package com.albanda.gamerapp.domain.usecase.auth

import com.albanda.gamerapp.domain.repository.AuthRepository
import jakarta.inject.Inject

class Logout @Inject constructor(private val authRepository: AuthRepository) {

    operator fun invoke() = authRepository.logout()

}