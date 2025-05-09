package com.albanda.gamerapp.presentation.screens.signup.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.navigation.NavHostController
import com.albanda.gamerapp.R
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.presentation.components.DefaultButton
import com.albanda.gamerapp.presentation.components.DefaultTextFiled
import com.albanda.gamerapp.presentation.navigation.AppScreen
import com.albanda.gamerapp.presentation.screens.signup.SignupViewModel
import com.albanda.gamerapp.presentation.ui.theme.DarkGray500

@Composable
fun CardForm(
    signupViewModel: SignupViewModel = hiltViewModel(),
    navHostController: NavHostController
) {

    val signupFlow = signupViewModel.signupFlow.collectAsState()

    Card(
        modifier = Modifier
            .padding(start = 40.dp, end = 40.dp, top = 200.dp),
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
                text = "REGISTRO",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Por favor ingresa estos datos para continuar.",
                fontSize = 12.sp,
                color = Color.Gray
            )

            DefaultTextFiled(
                modifier = Modifier.padding(top = 16.dp),
                value = signupViewModel.username.value,
                onValueChange = { signupViewModel.username.value = it },
                label = "Nombre de usuario",
                leadingIcon = Icons.Default.Person,
                errorMsg = signupViewModel.usernameErrMsg.value,
                validateField = { signupViewModel.validateUsername() }
            )

            DefaultTextFiled(
                modifier = Modifier.padding(top = 0.dp),
                value = signupViewModel.email.value,
                onValueChange = { signupViewModel.email.value = it },
                label = "Correo electrónico",
                leadingIcon = Icons.Default.Email,
                keyboardType = KeyboardType.Email,
                errorMsg = signupViewModel.emailErrMsg.value,
                validateField = { signupViewModel.validateEmail() }
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
                modifier = Modifier.padding(top = 0.dp),
                value = signupViewModel.password.value,
                onValueChange = { signupViewModel.password.value = it },
                label = "Password",
                leadingIcon = Icons.Default.Lock,
                trailingIcon = trailing,
                hideText = hideText,
                keyboardType = KeyboardType.Password,
                errorMsg = signupViewModel.passwordErrMsg.value,
                validateField = { signupViewModel.validatePassword() }
            )

            DefaultTextFiled(
                modifier = Modifier.padding(top = 0.dp),
                value = signupViewModel.confirmPassword.value,
                onValueChange = { signupViewModel.confirmPassword.value = it },
                label = "Password",
                leadingIcon = Icons.Outlined.Lock,
                trailingIcon = trailing,
                hideText = hideText,
                keyboardType = KeyboardType.Password,
                errorMsg = signupViewModel.confirmPasswordErrMsg.value,
                validateField = { signupViewModel.validateConfirmPassword() }
            )

            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                onClick = { signupViewModel.onSignup() },
                text = "REGISTRARSE",
                enable = signupViewModel.isEnabledLoginButton
            )
        }
    }

    signupFlow.value.let {
        when (it) {
            Response.Loading -> {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    CircularProgressIndicator()
                }
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
                    it.exception?.message ?: "Error desconocido",
                    Toast.LENGTH_LONG
                ).show()
            }

            null -> {}
        }
    }
}