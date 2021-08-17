package com.codeinger.myapplication.ui.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.codeinger.myapplication.R
import com.codeinger.myapplication.network.RetrofitBuilder
import com.codeinger.myapplication.network.repository.PostRepository
import com.codeinger.myapplication.utils.Resource

class PostActivity : AppCompatActivity() {

    val TAG = "PostActivityTag"

    private val mViewModel : PostViewModel by viewModels {
        PostViewModelFactory(
            PostRepository(RetrofitBuilder.postRequest)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        mViewModel.post.observe(this){
            when(it){
                is Resource.Failed -> Log.i(TAG, "Failed: ${it.message}")
                is Resource.Loading -> Log.i(TAG, "Loading: ")
                is Resource.Success -> Log.i(TAG, "Success: ${it.data}")
            }
        }

        mViewModel.getPost()
    }
}