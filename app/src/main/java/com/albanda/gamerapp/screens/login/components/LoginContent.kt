package com.albanda.gamerapp.screens.login.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.albanda.gamerapp.R
import com.albanda.gamerapp.ui.theme.GamerAppTheme

@Composable
fun LoginContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            modifier = Modifier.height(130.dp),
            painter = painterResource(id = R.drawable.control),
            contentDescription = "Xbox controller 360"
        )
        Text(
            text = "FIREBASE MVVM"
        )
        Text(
            modifier = Modifier.padding(top = 32.dp, bottom = 0.dp, start = 0.dp, end = 0.dp),
            text = "LOGIN"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Por favor, inicia sesión para continuar."
        )
        TextField(
            modifier = Modifier.padding(top = 25.dp),
            value = "",
            onValueChange = {},
            placeholder = {
                Text("Correo electrónico")
            }
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text("Contraseña")
            }
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 15.dp),
            onClick = {}
        ) {
            Text(
                text = "INICIAR SESION"
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginContent() {
    GamerAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            LoginContent()
        }
    }
}