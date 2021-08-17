package com.codeinger.myapplication.network.repository

import com.codeinger.myapplication.model.Post
import com.codeinger.myapplication.network.request.PostRequest
import com.codeinger.myapplication.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PostRepository(private val postRequest: PostRequest) {

     fun getPost() = flow<Resource<List<Post>>> {
         emit(Resource.loading())
         val posts = postRequest.getPost()
         emit(Resource.success(posts))
     }.catch {
         emit(Resource.failed(it.message!!))
     }.flowOn(Dispatchers.IO)

}




