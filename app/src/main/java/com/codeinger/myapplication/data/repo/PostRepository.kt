package com.codeinger.myapplication.data.repo

import androidx.lifecycle.asLiveData
import com.codeinger.myapplication.data.room.dao.PostDao
import com.codeinger.myapplication.model.Post

class PostRepository(private val postDao: PostDao) {

    fun loadAllPost() = postDao.loadAllPost().asLiveData()

    suspend fun insertAllPost(vararg posts : Post) = postDao.insertAllPost(*posts)

}