package com.albanda.gamerapp.presentation.screens.profile_edit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.albanda.gamerapp.presentation.components.DefaultButton
import com.albanda.gamerapp.presentation.components.DefaultTextFiled
import com.albanda.gamerapp.presentation.screens.profile_edit.ProfileEditViewModel
import com.albanda.gamerapp.presentation.ui.theme.DarkGray500

@Composable
fun CardForm(
    profileEditViewModel: ProfileEditViewModel = hiltViewModel()
) {

    val state = profileEditViewModel.state

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
                text = "EDITAR",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Introduce el nuevo nombre de usuario.",
                fontSize = 12.sp,
                color = Color.Gray
            )

            DefaultTextFiled(
                modifier = Modifier.padding(top = 16.dp),
                value = state.username,
                onValueChange = { profileEditViewModel.onUsernameInput(it) },
                label = "Nombre de usuario",
                leadingIcon = Icons.Default.Person,
                errorMsg = profileEditViewModel.usernameErrMsg,
                validateField = { profileEditViewModel.validateUsername() }
            )

            DefaultButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                onClick = { profileEditViewModel.onUpdate() },
                text = "ACTUALIZAR DATOS"
            )
        }
    }

}