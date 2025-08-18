package com.albanda.gamerapp.presentation.screens.posts

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.albanda.gamerapp.presentation.screens.posts.components.GetPosts

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PostsScreen(
    getPostsViewModel: GetPostsViewModel = hiltViewModel()
) {
    Scaffold (
        content = {
            GetPosts(getPostsViewModel)
        }
    )
}