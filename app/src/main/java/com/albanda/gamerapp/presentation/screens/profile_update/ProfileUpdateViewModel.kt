package com.albanda.gamerapp.presentation.screens.profile_update

import android.net.Uri
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
class ProfileUpdateViewModel @Inject constructor(
    saveStateHandle: SavedStateHandle,
    private val userUseCases: UserUseCases
) : ViewModel() {
    var state by mutableStateOf(ProfileUpdateState())
        private set

    var isUsernameValid by mutableStateOf(false)
        private set
    var usernameErrMsg by mutableStateOf("")
        private set

    var data = saveStateHandle.get<String>("user")
    val user = User.fromJson(data!!)

    var updateResponse by mutableStateOf<Response<Boolean>?>(null)
        private set

    var imageUri by mutableStateOf<Uri?>(null)
    var hasImage by mutableStateOf(false)

    init {
        state = state.copy(username = user.username)
    }

    fun onCameraResult(result: Boolean) {
        hasImage = result
    }

    fun onGalleryResult(uri: Uri?) {
        hasImage = uri != null
        imageUri = uri
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