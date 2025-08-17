package com.albanda.gamerapp.presentation.screens.create_post.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.presentation.components.ProgressBar
import com.albanda.gamerapp.presentation.screens.create_post.CreatePostViewModel

@Composable
fun CreatePostResponse(
    createPostViewModel: CreatePostViewModel = hiltViewModel()
) {

    when (val response = createPostViewModel.createPostResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success<*> -> {
            createPostViewModel.clearForm()
            Toast.makeText(
                LocalContext.current,
                "Publicación creada correctamente",
                Toast.LENGTH_LONG
            ).show()
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