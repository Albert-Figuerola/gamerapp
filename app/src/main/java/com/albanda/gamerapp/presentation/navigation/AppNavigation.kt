package com.albanda.gamerapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.albanda.gamerapp.presentation.screens.login.LoginScreen
import com.albanda.gamerapp.presentation.screens.profile.ProfileScreen
import com.albanda.gamerapp.presentation.screens.signup.SignupScreen

@Composable
fun AppNavigation(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        startDestination = AppScreen.Login.route
    ) {
        composable(route = AppScreen.Login.route) {
            LoginScreen(navHostController)
        }
        composable(route = AppScreen.Signup.route) {
            SignupScreen(navHostController)
        }
        composable(route = AppScreen.Profile.route) {
            ProfileScreen(navHostController)
        }
    }

}