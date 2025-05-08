package com.albanda.gamerapp.domain.usecase.auth

import com.albanda.gamerapp.domain.repository.AuthRepository
import javax.inject.Inject

class GetCurrentUser @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke() = authRepository.currentUser
}