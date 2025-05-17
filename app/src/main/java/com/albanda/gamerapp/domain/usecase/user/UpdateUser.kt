package com.albanda.gamerapp.domain.usecase.user

import com.albanda.gamerapp.domain.model.User
import com.albanda.gamerapp.domain.repository.UserRepository
import javax.inject.Inject

class UpdateUser @Inject constructor(private val userRepository: UserRepository) {

    suspend operator fun invoke(user: User) = userRepository.updateUser(user)

}