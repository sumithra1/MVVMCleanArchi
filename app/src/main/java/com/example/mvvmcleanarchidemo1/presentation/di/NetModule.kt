package com.example.mvvmcleanarchidemo1.presentation.di

import com.example.mvvmcleanarchidemo1.data.api.GamesAPIService
import com.example.mvvmcleanarchidemo1.data.util.Constants
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

    fun provideRetrofit() :Retrofit
{
    return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).
            baseUrl(Constants.BASE_URL)
        .build()
}
    @Singleton
    @Provides
    fun provideGampesApiService(retrofit: Retrofit):GamesAPIService {
        return retrofit.create(GamesAPIService::class.java)


    }
}