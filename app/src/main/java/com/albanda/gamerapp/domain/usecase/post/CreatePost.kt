package com.albanda.gamerapp.domain.usecase.post

import com.albanda.gamerapp.domain.model.Post
import com.albanda.gamerapp.domain.repository.PostRepository
import java.io.File
import javax.inject.Inject

class CreatePost @Inject constructor(private val postRepository: PostRepository) {

    suspend operator fun invoke(post: Post, file: File) = postRepository.createPost(post, file)

}