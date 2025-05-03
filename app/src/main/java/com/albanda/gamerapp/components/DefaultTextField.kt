package com.albanda.gamerapp.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun DefaultTextFiled(
    modifier: Modifier,
    value: String,
    onValueChange: (value: String) -> Unit,
    label: String,
    leadingIcon: ImageVector,
    trailingIcon: (@Composable (() -> Unit))? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { onValueChange(it) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        label = {
            Text(label)
        },
        leadingIcon = {
            Icon(
                imageVector = leadingIcon,
                contentDescription = "",
                tint = Color.White
            )
        },
        trailingIcon = trailingIcon,
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None
    )
}