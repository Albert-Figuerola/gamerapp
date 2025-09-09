package com.albanda.gamerapp.domain.usecase.post

import com.albanda.gamerapp.domain.repository.PostRepository
import javax.inject.Inject

class DeleteLikePost @Inject constructor(private val postRepository: PostRepository) {

    suspend operator fun invoke(postId: String, userId: String) = postRepository.deleteLike(postId, userId)

}