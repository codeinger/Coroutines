package com.codeinger.myapplication.ui.post

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codeinger.myapplication.model.Post
import com.codeinger.myapplication.network.repository.PostRepository
import com.codeinger.myapplication.utils.Resource
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {

    private val _posts : MutableLiveData<Resource<List<Post>>> = MutableLiveData()
    val post : LiveData<Resource<List<Post>>>
       get() = _posts

    fun getPost() = viewModelScope.launch {
        postRepository.getPost().collect {
            _posts.value = it
        }
    }
}
