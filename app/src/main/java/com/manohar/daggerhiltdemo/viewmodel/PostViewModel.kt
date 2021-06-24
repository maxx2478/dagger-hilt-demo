package com.manohar.daggerhiltdemo.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.manohar.daggerhiltdemo.model.Post
import com.manohar.daggerhiltdemo.repoository.XRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class PostViewModel
@Inject constructor(private val xrepository:XRepository) :ViewModel(){

    val response:LiveData<List<Post>> = xrepository.getPost()
        .catch { e->
            Log.d("main", "${e.message}")
        }.asLiveData()

}