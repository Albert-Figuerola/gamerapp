package com.albanda.gamerapp.presentation.navigation

sealed class RootScreen (val route: String) {
    object Home: RootScreen("home")
}