package com.albanda.gamerapp.presentation.screens.profile_update

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.domain.model.User
import com.albanda.gamerapp.domain.usecase.user.UserUseCases
import com.albanda.gamerapp.presentation.screens.utils.AuthFormValidator
import com.albanda.gamerapp.presentation.utils.ComposeFileProvider
import com.albanda.gamerapp.presentation.utils.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileUpdateViewModel @Inject constructor(
    saveStateHandle: SavedStateHandle,
    private val userUseCases: UserUseCases,
    @ApplicationContext private val context: Context
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

    var imageUri by mutableStateOf("")

    val resultingActivityHandler = ResultingActivityHandler()

    init {
        state = state.copy(username = user.username)
    }

    fun pickImage() = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*")
        if (result != null) {
            imageUri = result.toString()
        }
    }

    fun takePhoto() = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            imageUri = ComposeFileProvider.getPathFromBitmap(context, result)
        }

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