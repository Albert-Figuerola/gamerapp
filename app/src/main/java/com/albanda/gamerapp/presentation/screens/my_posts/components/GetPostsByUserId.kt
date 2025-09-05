package com.albanda.gamerapp.presentation.screens.my_posts.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.albanda.gamerapp.domain.model.Post
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.presentation.components.ProgressBar
import com.albanda.gamerapp.presentation.screens.my_posts.MyPostsViewModel

@Composable
fun GetPostsByUserId(
    navHostController: NavHostController,
    myPostsViewModel: MyPostsViewModel = hiltViewModel()
) {
    when (val response = myPostsViewModel.postsResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success<*> -> {
            MyPostsContent(navHostController, posts = response.data as List<Post>)
        }

        is Response.Failure<*> -> {
            Toast.makeText(
                LocalContext.current,
                response.exception?.message ?: "Error desconocido",
                Toast.LENGTH_LONG
            ).show()
        }

        null -> {}
    }
}