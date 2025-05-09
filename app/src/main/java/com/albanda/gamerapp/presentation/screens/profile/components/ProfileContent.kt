package com.albanda.gamerapp.presentation.screens.profile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.albanda.gamerapp.R
import com.albanda.gamerapp.presentation.components.DefaultButton
import com.albanda.gamerapp.presentation.navigation.AppScreen
import com.albanda.gamerapp.presentation.screens.profile.ProfileViewModel

@Composable
fun ProfileContent(
    profileViewModel: ProfileViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box() {
            Image(
                modifier = Modifier.fillMaxWidth().height(200.dp),
                alpha = 0.6f,
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.background),
                contentDescription = "Profile background image"
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = "Bienvenido",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(55.dp))

                Image(
                    modifier = Modifier.size(115.dp),
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "Profile background image"
                )
            }
        }

        Spacer(modifier = Modifier.height(55.dp))

        Text(
            text = "Nombre de usuario",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )
        Text(
            text = "Mail del usuario",
            fontSize = 15.sp,
            fontStyle = FontStyle.Italic
        )

        Spacer(modifier = Modifier.height(20.dp))

        DefaultButton(
            modifier = Modifier.width(250.dp),
            text = "Editar datos",
            icon = Icons.Default.Edit,
            color = Color.White,
            colorContent = Color.Black,
            onClick = {

            }
        )

        Spacer(modifier = Modifier.height(10.dp))

        DefaultButton(
            modifier = Modifier.width(250.dp),
            text = "Cerrar sesión",
            icon = Icons.AutoMirrored.Default.ExitToApp,
            onClick = {
                profileViewModel.logout()
                navHostController.navigate(route = AppScreen.Login.route){
                    popUpTo(AppScreen.Profile.route) { inclusive = true }
                }
            }
        )
    }

}