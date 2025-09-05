package com.albanda.gamerapp.domain.usecase.post

data class PostUseCases (
    val createPost: CreatePost,
    val getPosts: GetPosts,
    val getPostsByUserId: GetPostsByUserId
)