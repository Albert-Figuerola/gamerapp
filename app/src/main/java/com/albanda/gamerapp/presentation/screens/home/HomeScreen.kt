package com.albanda.gamerapp.presentation.screens.home

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.albanda.gamerapp.presentation.navigation.HomeBottomBarNavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navHostController: NavHostController = rememberNavController()) {
    Scaffold() {
        HomeBottomBarNavGraph(navHostController = navHostController)
    }
}