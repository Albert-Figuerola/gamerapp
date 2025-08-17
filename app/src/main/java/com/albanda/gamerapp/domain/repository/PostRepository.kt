package com.albanda.gamerapp.domain.repository

import com.albanda.gamerapp.domain.model.Post
import com.albanda.gamerapp.domain.model.Response
import java.io.File

interface PostRepository {

    suspend fun createPost(post: Post, file: File): Response<Boolean>


}