package com.example.data.di

import com.example.data.api.GamesApiService
import com.example.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {
    @Singleton
    @Provides

    fun provideRetrofit() : Retrofit
    {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).
        baseUrl(Constants.BASE_URL)
            .build()
    }
    @Singleton
    @Provides
    fun provideGampesApiService(retrofit: Retrofit):GamesApiService {
        return retrofit.create(GamesApiService::class.java)


    }
}