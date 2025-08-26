package com.albanda.gamerapp.domain.model

import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

data class Post(
    var id: String = "",
    var name: String = "",
    var description: String = "",
    var category: String = "",
    var image: String = "",
    var userId: String = "",
    var user: User? = null
) {
    fun toJson(): String = Gson().toJson(
        Post(
            id,
            name,
            description,
            category,
            if (image != "") URLEncoder.encode(image, StandardCharsets.UTF_8.toString()) else "",
            userId,
            User(
                id = user?.id ?: "",
                username = user?.username ?: "",
                image = if (user?.image != "") URLEncoder.encode(user?.image, StandardCharsets.UTF_8.toString()) else "",
                email = user?.email ?: ""
            )
        )
    )

    companion object {
        fun fromJson(data: String): Post = Gson().fromJson(data, Post::class.java)
    }
}