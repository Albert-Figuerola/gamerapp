package com.albanda.gamerapp.presentation.screens.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.albanda.gamerapp.R
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.presentation.components.DefaultButton
import com.albanda.gamerapp.presentation.components.DefaultTextFiled
import com.albanda.gamerapp.presentation.screens.login.LoginViewModel
import com.albanda.gamerapp.presentation.ui.theme.DarkGray500
import com.albanda.gamerapp.presentation.ui.theme.Red500

@Composable
fun LoginContent(viewModel: LoginViewModel = hiltViewModel()) {
    val loginFlow = viewModel.loginFlow.collectAsState()

    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .background(Red500)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(32.dp))
                Image(
                    modifier = Modifier.height(130.dp),
                    painter = painterResource(id = R.drawable.control),
                    contentDescription = "Xbox controller 360"
                )
                Text(
                    text = "FIREBASE MVVM"
                )
            }
        }

        Card(
            modifier = Modifier.padding(start = 40.dp, end = 40.dp, top = 200.dp),
            colors = CardDefaults.cardColors(containerColor = DarkGray500)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(
                            top = 32.dp,
                            bottom = 0.dp,
                            start = 0.dp,
                            end = 0.dp
                        ),
                    text = "LOGIN",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Por favor, inicia sesión para continuar.",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                DefaultTextFiled(
                    modifier = Modifier.padding(top = 16.dp),
                    value = viewModel.email.value,
                    onValueChange = { viewModel.email.value = it },
                    label = "Correo electrónico",
                    leadingIcon = Icons.Default.Email,
                    keyboardType = KeyboardType.Email,
                    errorMsg = viewModel.emailErrMsg.value,
                    validateField = {
                        viewModel.validateEmail()
                    }
                )

                var hideText by remember { mutableStateOf(true) }
                val trailing: @Composable () -> Unit = {
                    val image = if (hideText) {
                        R.drawable.visibility_off
                    } else {
                        R.drawable.visibility
                    }

                    IconButton(onClick = { hideText = !hideText }) {
                        Icon(
                            painter = painterResource(id = image),
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }

                DefaultTextFiled(
                    modifier = Modifier.padding(top = 6.dp),
                    value = viewModel.password.value,
                    onValueChange = { viewModel.password.value = it },
                    label = "Password",
                    leadingIcon = Icons.Default.Lock,
                    trailingIcon = trailing,
                    hideText = hideText,
                    keyboardType = KeyboardType.Password,
                    errorMsg = viewModel.passwordErrMsg.value,
                    validateField = {
                        viewModel.validatePassword()
                    }
                )

                DefaultButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 32.dp),
                    onClick = {
                        viewModel.login()
                    },
                    text = "INICIAR SESIÓN",
                    enable = viewModel.isEnabledLoginButton
                )
            }
        }
    }

    loginFlow.value.let { state ->
        when(state) {
            Response.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
            }
            is Response.Success<*> -> {
                Toast.makeText(LocalContext.current, "Usuario logeado", Toast.LENGTH_LONG).show()
            }

            is Response.Failure<*> -> {
                Toast.makeText(LocalContext.current, state.exception?.message ?: "Error desconocido", Toast.LENGTH_LONG).show()
            }

            null -> { }
        }
    }

}

/*@Composable
fun PasswordTextField() {
    //var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier.padding(top = 6.dp),
        value = "",
        onValueChange = {},
        label = {
            Text("Contraseña")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "",
                tint = Color.White
            )
        },
        trailingIcon = {
            val image = if (passwordVisible) {
                R.drawable.visibility
            } else {
                R.drawable.visibility_off
            }

            IconButton(onClick = { passwordVisible = !passwordVisible } ) {
                Icon(
                    painter = painterResource(id = image),
                    contentDescription = "",
                    tint = Color.White
                )
            }
        }
    )
}*/

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PreviewLoginContent() {
//    GamerAppTheme(darkTheme = true) {
//        Surface(
//            modifier = Modifier.fillMaxSize(),
//            color = MaterialTheme.colorScheme.background
//        ) {
//            LoginContent(null)
//        }
//    }
//}