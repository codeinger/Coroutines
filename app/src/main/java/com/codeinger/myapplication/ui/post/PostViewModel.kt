package com.codeinger.myapplication.ui.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinger.myapplication.data.repo.PostRepository
import com.codeinger.myapplication.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {

    val postLiveData = postRepository.loadAllPost()

    fun insertAllPost(vararg post : Post) = viewModelScope.launch(){
        postRepository.insertAllPost(*post)
    }

}