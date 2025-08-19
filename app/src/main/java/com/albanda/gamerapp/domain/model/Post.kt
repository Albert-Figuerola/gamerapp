package com.albanda.gamerapp.domain.model

data class Post (
    var id: String = "",
    var name: String = "",
    var description: String = "",
    var category: String = "",
    var image: String = "",
    var userId: String = "",
    var user: User = User()
)