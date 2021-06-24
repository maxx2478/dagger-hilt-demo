package com.manohar.daggerhiltdemo.repoository

import com.manohar.daggerhiltdemo.model.Post
import com.manohar.daggerhiltdemo.network.ApiImplementation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class XRepository
@Inject constructor(private val apiImplementation: ApiImplementation) {

    fun getPost(): Flow<List<Post>> = flow {
        val response = apiImplementation.getPost()
        emit(response)
    }.flowOn(Dispatchers.IO)

}