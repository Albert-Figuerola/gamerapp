package com.albanda.gamerapp.presentation.screens.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albanda.gamerapp.domain.model.User
import com.albanda.gamerapp.domain.usecase.auth.AuthUseCases
import com.albanda.gamerapp.domain.usecase.user.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authUseCases: AuthUseCases,
    private val userUseCases: UserUseCases
): ViewModel() {

    var userData by mutableStateOf(User())
        private set

    val currentUserId = authUseCases.getCurrentUser()

    init {
        getUserById()
    }

    private fun getUserById() = viewModelScope.launch {
        userUseCases.getUserById(currentUserId!!.uid).collect() { user ->
            userData = user
        }
    }

    fun logout() {
        authUseCases.logout()
    }

}