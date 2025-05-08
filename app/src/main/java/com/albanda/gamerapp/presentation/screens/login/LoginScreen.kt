package com.albanda.gamerapp.presentation.screens.login

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
import com.albanda.gamerapp.presentation.screens.login.components.LoginBottomBar
import com.albanda.gamerapp.presentation.screens.login.components.LoginContent
import com.albanda.gamerapp.presentation.ui.theme.GamerAppTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(navHostController: NavHostController) {

    Scaffold(
        topBar = {},
        content = {
            LoginContent(navHostController)
        },
        bottomBar = {
            LoginBottomBar(navHostController)
        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    GamerAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(rememberNavController())
        }
    }
}