package com.albanda.gamerapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.albanda.gamerapp.presentation.screens.home.HomeScreen
import com.albanda.gamerapp.presentation.screens.profile_update.ProfileEditScreen

@Composable
fun RootNavGraph(navHostController: NavHostController) {

    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navHostController = navHostController)
        composable(route = RootScreen.Home.route) {
            HomeScreen()
        }

        composable(
            route = AuthScreen.ProfileEdit.route,
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