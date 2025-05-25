package com.albanda.gamerapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.albanda.gamerapp.presentation.screens.login.LoginScreen
import com.albanda.gamerapp.presentation.screens.profile.ProfileScreen
import com.albanda.gamerapp.presentation.screens.profile_update.ProfileEditScreen
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

        composable(
            route = AppScreen.ProfileEdit.route,
            arguments = listOf(navArgument("user") {
                type = NavType.StringType
            })
        ) {
            it.arguments?.getString("user")?.let {
                ProfileEditScreen(navHostController)
            }
        }

    }

}