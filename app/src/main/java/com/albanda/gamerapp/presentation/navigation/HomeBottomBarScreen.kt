package com.albanda.gamerapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class HomeBottomBarScreen (
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Posts: HomeBottomBarScreen(
        route = "posts",
        title = "Posts",
        icon = Icons.Default.List
    )

    object MyPosts: HomeBottomBarScreen(
        route = "my_posts",
        title = "My posts",
        icon = Icons.Default.List
    )

    object Profile: HomeBottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}