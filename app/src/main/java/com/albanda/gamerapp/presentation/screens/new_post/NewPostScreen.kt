package com.albanda.gamerapp.presentation.screens.new_post

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.albanda.gamerapp.presentation.components.DefaultButton
import com.albanda.gamerapp.presentation.components.DefaultTopBar
import com.albanda.gamerapp.presentation.screens.new_post.components.NewPostContent

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NewPostScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo Post",
                upAvailable = true,
                navHostController = navHostController
            )
        },
        content = {
            NewPostContent()
        },
        bottomBar = {
            DefaultButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Publicar",
                onClick = { }
            )
        }
    )
}