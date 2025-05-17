package com.albanda.gamerapp.domain.model

import com.google.gson.Gson

data class User(
    var id: String = "",
    var username: String = "",
    var image: String = "",
    var email: String = "",
    var password: String = ""
) {
    fun toJson(): String = Gson().toJson(this)

    companion object {
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }
}