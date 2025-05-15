package com.albanda.gamerapp.presentation.screens.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.albanda.gamerapp.presentation.components.DefaultTopBar
import com.albanda.gamerapp.presentation.screens.signup.components.SignUp
import com.albanda.gamerapp.presentation.screens.signup.components.SignupContent
import com.albanda.gamerapp.presentation.ui.theme.GamerAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SignupScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            DefaultTopBar(
                title = "Nuevo usuario",
                upAvailable = true,
                navHostController = navHostController
            )
        },
        content = {
            SignupContent(navHostController)
        },
        bottomBar = {}
    )
    SignUp(navHostController)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSignupScreen() {
    GamerAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SignupScreen(rememberNavController())
        }
    }
}
