package com.albanda.gamerapp.presentation.navigation


sealed class AuthScreen(val route: String) {

    object Login: AuthScreen("login")
    object Signup: AuthScreen("signup")

    object Profile: AuthScreen("profile")
    object ProfileEdit: AuthScreen("profile/edit/{user}") {
        fun passUser(user: String) = "profile/edit/$user"
    }
}