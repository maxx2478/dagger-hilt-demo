package com.manohar.daggerhiltdemo.network

import com.manohar.daggerhiltdemo.model.Post
import retrofit2.http.GET

interface PostApiService {

    @GET("posts")
    suspend fun getApi() :  List<Post>


}