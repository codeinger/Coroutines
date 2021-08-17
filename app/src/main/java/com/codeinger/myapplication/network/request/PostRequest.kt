package com.codeinger.myapplication.network.request

import com.codeinger.myapplication.model.Post
import retrofit2.http.GET

interface PostRequest {
    @GET("posts")
    suspend fun getPost():List<Post>
}