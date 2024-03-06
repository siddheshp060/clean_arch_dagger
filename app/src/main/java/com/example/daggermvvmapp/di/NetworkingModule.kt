package com.example.daggermvvmapp.di

import com.example.daggermvvmapp.Constants
import com.example.daggermvvmapp.retrofit.ApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkingModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getApiInterface(retrofit: Retrofit) : ApiInterface{
        return retrofit.create(ApiInterface::class.java)
    }
}