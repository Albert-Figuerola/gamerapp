package com.albanda.gamerapp.presentation.screens.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.albanda.gamerapp.presentation.screens.utils.AuthFormValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel() {
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrMsg: MutableState<String> = mutableStateOf("")

    var isEnabledLoginButton = false

    fun validateEmail() {
        isEmailValid.value = AuthFormValidator.isEmailValid(email.value)
        emailErrMsg.value = if (isEmailValid.value) "" else "El correo electrónico no es válido"

        enabledLoginButton()
    }

    fun validatePassword() {
        isPasswordValid.value = AuthFormValidator.isPasswordValid(password.value)
        passwordErrMsg.value = if (isPasswordValid.value) "" else "Al menos 6 caracteres"

        enabledLoginButton()
    }

    fun enabledLoginButton() {
        isEnabledLoginButton = isEmailValid.value && isPasswordValid.value
    }
}