package com.codeinger.myapplication.network

import com.codeinger.myapplication.network.request.PostRequest
import com.codeinger.myapplication.utils.NetworkConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private fun getInstance():Retrofit{
        return Retrofit.Builder().baseUrl(NetworkConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val postRequest = getInstance().create(PostRequest::class.java)
}