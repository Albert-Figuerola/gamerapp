package com.albanda.gamerapp.presentation.screens.signup

import android.util.Patterns
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor() : ViewModel() {
    var username: MutableState<String> = mutableStateOf("")
    var isUsernameValid: MutableState<Boolean> = mutableStateOf(false)
    var usernameErrMsg: MutableState<String> = mutableStateOf("")

    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrMsg: MutableState<String> = mutableStateOf("")

    var confirmPassword: MutableState<String> = mutableStateOf("")
    var isConfirmPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var confirmPasswordErrMsg: MutableState<String> = mutableStateOf("")

    var isEnabledLoginButton = false

    fun validateUsername() {
        if (username.value.length >= 5) {
            isUsernameValid.value = true
            usernameErrMsg.value = ""
        } else {
            usernameErrMsg.value = "Almenos 5 caracteres"
        }

        enabledSignupButton()
    }

    fun validateEmail() {
        if (Patterns.EMAIL_ADDRESS.matcher(email.value).matches()) {
            isEmailValid.value = true
            emailErrMsg.value = ""
        } else {
            isEmailValid.value = false
            emailErrMsg.value = "El email no es válido."
        }

        enabledSignupButton()
    }

    fun validatePassword() {
        if (password.value.length >= 6) {
            isPasswordValid.value = true
            passwordErrMsg.value = ""
        } else {
            isPasswordValid.value = false
            passwordErrMsg.value = "Al menos 6 caracteres."
        }

        enabledSignupButton()
    }

    fun validateConfirmPassword() {
        if (confirmPassword.value == password.value) {
            isConfirmPasswordValid.value = true
            confirmPasswordErrMsg.value = ""
        } else {
            isConfirmPasswordValid.value = false
            confirmPasswordErrMsg.value = "Las contraseñas no coinciden"
        }

        enabledSignupButton()
    }

    fun enabledSignupButton() {
        isEnabledLoginButton = isEmailValid.value &&
                isPasswordValid.value &&
                isUsernameValid.value &&
                isConfirmPasswordValid.value
    }
}