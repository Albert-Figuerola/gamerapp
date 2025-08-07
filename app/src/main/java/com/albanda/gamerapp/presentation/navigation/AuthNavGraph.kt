package com.albanda.gamerapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.albanda.gamerapp.presentation.screens.login.LoginScreen
import com.albanda.gamerapp.presentation.screens.signup.SignupScreen

fun NavGraphBuilder.authNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navHostController)
        }

        composable(route = AuthScreen.Signup.route) {
            SignupScreen(navHostController)
        }
    }
}

sealed class AuthScreen(val route: String) {
    object Login: AuthScreen("login")
    object Signup: AuthScreen("signup")
}