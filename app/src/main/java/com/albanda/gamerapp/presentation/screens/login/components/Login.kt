package com.albanda.gamerapp.presentation.screens.login.components

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.presentation.components.ProgressBar
import com.albanda.gamerapp.presentation.navigation.AppScreen
import com.albanda.gamerapp.presentation.screens.login.LoginViewModel

@Composable
fun Login(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navHostController: NavHostController
) {

    when (val loginResponse = loginViewModel.loginResponse) {
        Response.Loading -> {
            ProgressBar()
        }

        is Response.Success<*> -> {
            LaunchedEffect(Unit) {
                navHostController.navigate(route = AppScreen.Profile.route) {
                    popUpTo(AppScreen.Login.route) { inclusive = true }
                }
            }
        }

        is Response.Failure<*> -> {
            Toast.makeText(
                LocalContext.current,
                loginResponse.exception?.message ?: "Error desconocido",
                Toast.LENGTH_LONG
            ).show()
        }

        null -> {}
    }

}