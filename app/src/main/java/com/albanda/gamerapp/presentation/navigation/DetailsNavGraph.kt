package com.albanda.gamerapp.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.albanda.gamerapp.presentation.screens.create_post.CreatePostScreen
import com.albanda.gamerapp.presentation.screens.profile_update.ProfileEditScreen

fun NavGraphBuilder.detailsNavGraph(navHostController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.ProfileUpdate.route
    ) {
        composable(route = DetailsScreen.CreatePost.route) {
            CreatePostScreen(navHostController)
        }

        composable(
            route = DetailsScreen.ProfileUpdate.route,
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

sealed class DetailsScreen(val route: String) {
    object CreatePost: DetailsScreen("post/new")
    object ProfileUpdate: DetailsScreen("profile/edit/{user}") {
        fun passUser(user: String) = "profile/edit/$user"
    }
}