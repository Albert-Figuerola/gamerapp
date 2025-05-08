package com.albanda.gamerapp.presentation.screens.profile

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.albanda.gamerapp.presentation.components.DefaultButton
import com.albanda.gamerapp.presentation.navigation.AppScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreen(navHostController: NavHostController, profileViewModel: ProfileViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {},
        content = {
            DefaultButton(
                modifier = Modifier,
                text = "Cerrar sesión",
                onClick = {
                    profileViewModel.logout()
                    navHostController.navigate(route = AppScreen.Login.route){
                        popUpTo(AppScreen.Profile.route) { inclusive = true }
                    }
                }
            )
        },
        bottomBar = {}
    )
}