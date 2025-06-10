package com.albanda.gamerapp.domain.usecase.user

import com.albanda.gamerapp.domain.repository.UserRepository
import javax.inject.Inject

class GetUserById @Inject constructor(private val userRepository: UserRepository) {

    operator fun invoke(userId: String) = userRepository.getUserById(userId)

}