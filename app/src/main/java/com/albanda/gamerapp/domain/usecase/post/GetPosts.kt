package com.albanda.gamerapp.domain.usecase.post

import com.albanda.gamerapp.domain.repository.PostRepository
import javax.inject.Inject

class GetPosts @Inject constructor(
    private val postRepository: PostRepository
) {

    operator fun invoke() = postRepository.getPosts()

}