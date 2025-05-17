package com.albanda.gamerapp.domain.usecase.user

data class UserUseCases(
    val createUser: CreateUser,
    val getUseById: GetUseById,
    val updateUser: UpdateUser
)