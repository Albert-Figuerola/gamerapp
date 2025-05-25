package com.albanda.gamerapp.presentation.screens.profile_update

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.albanda.gamerapp.presentation.components.DefaultTopBar
import com.albanda.gamerapp.presentation.screens.profile_update.components.ProfileUpdateContent
import com.albanda.gamerapp.presentation.screens.profile_update.components.ProfileUpdate

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileEditScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Editar perfil",
                upAvailable = true,
                navHostController = navHostController
            )
        },
        content = {
            ProfileUpdateContent()
        },
        bottomBar = {}
    )
    ProfileUpdate()
}