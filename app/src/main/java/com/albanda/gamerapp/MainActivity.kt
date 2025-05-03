package com.albanda.gamerapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.albanda.gamerapp.ui.theme.GamerAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamerAppTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BodyContent()
                }
            }
        }
    }
}

@Composable
fun BodyContent() {
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
        Row(

        ) {
            Text(
                text = "No tienes cuenta?",
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.width(7.dp))
            Text(
                text = "REGISTRATE AQUI",
                color = Color.Red,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    GamerAppTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            BodyContent()
        }
    }
}
