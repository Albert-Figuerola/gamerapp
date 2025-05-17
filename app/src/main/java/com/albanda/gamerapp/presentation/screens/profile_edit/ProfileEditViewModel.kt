package com.albanda.gamerapp.presentation.screens.profile_edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.domain.model.User
import com.albanda.gamerapp.domain.usecase.user.UserUseCases
import com.albanda.gamerapp.presentation.screens.utils.AuthFormValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileEditViewModel @Inject constructor(
    saveStateHandle: SavedStateHandle,
    private val userUseCases: UserUseCases
) : ViewModel() {
    var state by mutableStateOf(ProfileEditState())
        private set

    var isUsernameValid by mutableStateOf(false)
        private set
    var usernameErrMsg by mutableStateOf("")
        private set

    var data = saveStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    var updateResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    init {
        state = state.copy(username = user.username)
    }

    fun onUpdate() {
        val myUser = User(
            id = user.id,
            username = state.username,
            image = ""
        )
        updateUser(myUser)
    }

    fun updateUser(user: User) = viewModelScope.launch {
        updateResponse = Response.Loading
        val result = userUseCases.updateUser(user)
        updateResponse = result
    }

    fun onUsernameInput(username: String) {
        state = state.copy(username = username)
    }

    fun validateUsername() {
        isUsernameValid = AuthFormValidator.isUsernameValid(state.username)
        usernameErrMsg = if (isUsernameValid) "" else "Almenos 5 caracteres"
    }

}