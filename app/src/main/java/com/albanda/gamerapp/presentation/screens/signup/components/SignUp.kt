package com.albanda.gamerapp.presentation.screens.signup.components

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.presentation.components.ProgressBar
import com.albanda.gamerapp.presentation.navigation.AppScreen
import com.albanda.gamerapp.presentation.screens.signup.SignupViewModel

@Composable
fun SignUp(
    navHostController: NavHostController,
    signupViewModel: SignupViewModel = hiltViewModel()
) {
    when (val signupResponse = signupViewModel.signupResponse) {
        Response.Loading -> {
            Log.i("CardForm", "Loading")
            ProgressBar()
        }

        is Response.Success<*> -> {
            LaunchedEffect(Unit) {
                signupViewModel.createUser()
                navHostController.popBackStack(AppScreen.Login.route, inclusive = true)
                navHostController.navigate(route = AppScreen.Profile.route)
            }
        }

        is Response.Failure<*> -> {
            Toast.makeText(
                LocalContext.current,
                signupResponse.exception?.message ?: "Error desconocido",
                Toast.LENGTH_LONG
            ).show()
        }

        null -> {}
    }
}