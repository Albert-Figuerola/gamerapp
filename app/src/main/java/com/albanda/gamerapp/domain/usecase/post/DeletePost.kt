package com.albanda.gamerapp.domain.usecase.post

import com.albanda.gamerapp.domain.repository.PostRepository
import javax.inject.Inject

class DeletePost @Inject constructor(private val postRepository: PostRepository) {

    suspend operator fun invoke(postId: String) = postRepository.deletePost(postId)

}