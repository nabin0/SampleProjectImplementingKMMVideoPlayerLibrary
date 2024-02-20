package com.github.nabin0.kmmvideoplayersampleandroid.di

import com.github.nabin0.kmmvideoplayersampleandroid.data.network.VideoService
import com.github.nabin0.kmmvideoplayersampleandroid.data.network.VideoService.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    @Singleton
    fun provideJobService(): VideoService {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(VideoService::class.java)
    }
}