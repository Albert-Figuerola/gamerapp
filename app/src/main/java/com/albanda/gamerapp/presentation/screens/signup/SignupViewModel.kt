package com.albanda.gamerapp.presentation.screens.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.domain.model.User
import com.albanda.gamerapp.domain.usecase.auth.AuthUseCases
import com.albanda.gamerapp.presentation.screens.utils.AuthFormValidator
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SignupViewModel @Inject constructor(private val authUseCases: AuthUseCases) : ViewModel() {
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

    private val _signupFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val signupFlow: StateFlow<Response<FirebaseUser>?> = _signupFlow

    fun signup(user: User) = viewModelScope.launch {
        _signupFlow.value = Response.Loading
        val result = authUseCases.signup(user)
        _signupFlow.value = result
    }

    fun validateUsername() {
        isUsernameValid.value = AuthFormValidator.isUsernameValid(username.value)
        usernameErrMsg.value = if (isUsernameValid.value) "" else "Almenos 5 caracteres"

        enabledSignupButton()
    }

    fun validateEmail() {
        isEmailValid.value = AuthFormValidator.isEmailValid(email.value)
        emailErrMsg.value = if (isEmailValid.value) "" else "El correo electrónico no es válido"

        enabledSignupButton()
    }

    fun validatePassword() {
        isPasswordValid.value = AuthFormValidator.isPasswordValid(password.value)
        passwordErrMsg.value = if (isPasswordValid.value) "" else "Al menos 6 caracteres"

        enabledSignupButton()
    }

    fun validateConfirmPassword() {
        isConfirmPasswordValid.value = AuthFormValidator.isConfirmPasswordValid(password.value, confirmPassword.value)
        confirmPasswordErrMsg.value = if (isConfirmPasswordValid.value) "" else "Las contraseñas no coinciden"

        enabledSignupButton()
    }

    fun enabledSignupButton() {
        isEnabledLoginButton = isEmailValid.value &&
                isPasswordValid.value &&
                isUsernameValid.value &&
                isConfirmPasswordValid.value
    }
}