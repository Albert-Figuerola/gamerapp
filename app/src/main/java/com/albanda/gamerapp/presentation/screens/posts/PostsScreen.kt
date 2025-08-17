package com.albanda.gamerapp.presentation.screens.posts

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.albanda.gamerapp.presentation.screens.posts.components.GetPosts

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PostsScreen(
    navHostController: NavHostController,
    getPostsViewModel: GetPostsViewModel = hiltViewModel()
) {
    Scaffold (
        content = {
            Text(text = "PostScreen")
            GetPosts(getPostsViewModel)
        }
    )
}