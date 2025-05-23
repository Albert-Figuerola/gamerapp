package com.albanda.gamerapp.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.albanda.gamerapp.presentation.ui.theme.Red500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean = false,
    navHostController: NavHostController? = null
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 18.sp
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Red500),
        navigationIcon = {
            if (upAvailable) {
                IconButton(onClick = { navHostController?.popBackStack() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        }
    )
}

