package com.manohar.daggerhiltdemo.di

import com.manohar.daggerhiltdemo.network.PostApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun providesBaseUrl():String = "https://jsonplaceholder.typicode.com/"

    @Provides
    @Singleton
   fun providesRetrofit(baseurl:String) : Retrofit =
       Retrofit.Builder()
           .baseUrl(baseurl)
           .addConverterFactory(GsonConverterFactory.create())
           .build()

    @Provides
    fun provideApiInterface(retrofit: Retrofit) : PostApiService =
        retrofit.create(PostApiService::class.java)

}