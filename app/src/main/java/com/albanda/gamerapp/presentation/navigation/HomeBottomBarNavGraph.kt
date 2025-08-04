package com.albanda.gamerapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.albanda.gamerapp.presentation.screens.my_posts.MyPostsScreen
import com.albanda.gamerapp.presentation.screens.posts.PostScreen
import com.albanda.gamerapp.presentation.screens.profile.ProfileScreen

@Composable
fun HomeBottomBarNavGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.HOME,
        startDestination = HomeBottomBarScreen.Posts.route
    ) {
        composable(route = HomeBottomBarScreen.Posts.route) {
            PostScreen(navHostController)
        }

        composable(route = HomeBottomBarScreen.MyPosts.route) {
            MyPostsScreen(navHostController)
        }

        composable(route = HomeBottomBarScreen.Profile.route) {
            ProfileScreen(navHostController)
        }
    }
}