package com.albanda.gamerapp.domain.usecase.user

import com.albanda.gamerapp.domain.repository.UserRepository
import java.io.File
import javax.inject.Inject

class SaveImage @Inject constructor(
    private val userRepository: UserRepository
) {

    suspend operator fun invoke(file: File) = userRepository.saveImage(file)

}