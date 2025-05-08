package com.albanda.gamerapp.presentation.screens.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.domain.usecase.auth.AuthUseCases
import com.albanda.gamerapp.presentation.screens.utils.AuthFormValidator
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
): ViewModel() {
    var email: MutableState<String> = mutableStateOf("")
    var isEmailValid: MutableState<Boolean> = mutableStateOf(false)
    var emailErrMsg: MutableState<String> = mutableStateOf("")

    var password: MutableState<String> = mutableStateOf("")
    var isPasswordValid: MutableState<Boolean> = mutableStateOf(false)
    var passwordErrMsg: MutableState<String> = mutableStateOf("")

    var isEnabledLoginButton = false

    private var _loginFlow = MutableStateFlow<Response<FirebaseUser>?>(null)
    val loginFlow: StateFlow<Response<FirebaseUser>?> = _loginFlow

    val currentUser = authUseCases.getCurrentUser()

    init {
        if (currentUser != null) {
            _loginFlow.value = Response.Success(currentUser)
        }
    }

    fun login() = viewModelScope.launch {
        _loginFlow.value = Response.Loading
        val result = authUseCases.login(email.value, password.value)
        _loginFlow.value = result
    }

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