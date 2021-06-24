package com.manohar.daggerhiltdemo.network

import com.manohar.daggerhiltdemo.model.Post
import javax.inject.Inject

class ApiImplementation @Inject constructor(private val postApiService: PostApiService){

    suspend fun getPost():List<Post> = postApiService.getApi()

}