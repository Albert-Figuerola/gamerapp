package com.albanda.gamerapp.presentation.screens.profile_edit.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.presentation.components.ProgressBar
import com.albanda.gamerapp.presentation.screens.profile_edit.ProfileEditViewModel

@Composable
fun UpdateUser(profileEditViewModel: ProfileEditViewModel = hiltViewModel()) {

    when (val updateResponse = profileEditViewModel.updateResponse) {
        Response.Loading -> ProgressBar()

        is Response.Success<*> -> Toast.makeText(
            LocalContext.current,
            "Datos actualizados correctamente",
            Toast.LENGTH_LONG
        ).show()

        is Response.Failure<*> -> Toast.makeText(
            LocalContext.current,
            updateResponse.exception?.message ?: "Error al actualizar datos",
            Toast.LENGTH_LONG
        ).show()

        null -> {}
    }

}