package com.albanda.gamerapp.presentation.screens.posts

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.albanda.gamerapp.domain.model.Post
import com.albanda.gamerapp.domain.model.Response
import com.albanda.gamerapp.domain.usecase.post.PostUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetPostsViewModel @Inject constructor(
    private val postUseCases: PostUseCases
): ViewModel() {

    var postsResponse by mutableStateOf<Response<List<Post>>?>(null)

    init {
        getPosts()
    }

    fun getPosts() = viewModelScope.launch {
        postsResponse = Response.Loading
        postUseCases.getPosts().collect() { response ->
            postsResponse = response
        }
    }

}