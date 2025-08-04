package com.albanda.gamerapp.presentation.screens.my_posts

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyPostsScreen(navHostController: NavHostController) {
    Scaffold (
        content = {
            Text(text = "MyPostsScreen")
        }
    )
}