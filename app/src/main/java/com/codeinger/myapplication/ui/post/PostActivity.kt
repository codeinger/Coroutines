package com.codeinger.myapplication.ui.post

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.codeinger.myapplication.R
import com.codeinger.myapplication.data.repo.PostRepository
import com.codeinger.myapplication.data.room.MyDatabase
import com.codeinger.myapplication.model.Post

class PostActivity : AppCompatActivity() {

    private val postViewModel : PostViewModel by viewModels{
        PostViewModelFactory(PostRepository(MyDatabase.getInstance(applicationContext).postDao()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post2)

        postViewModel.postLiveData.observe(this){
            Log.i("jdbhjcbdf", "onCreate: "+it)
        }

        postViewModel.insertAllPost(
            Post(0,"title1","des"),
            Post(0,"title2","des"),
            Post(0,"title3","des"),
            Post(0,"title4","des"),
            Post(0,"title5","des"),
            Post(0,"title6","des")
        )

    }
}