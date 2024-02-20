package com.github.nabin0.kmmvideoplayersampleandroid.di

import com.github.nabin0.kmmvideoplayersampleandroid.data.network.VideoService
import com.github.nabin0.kmmvideoplayersampleandroid.data.repository.VideosRepositoryImpl
import com.github.nabin0.kmmvideoplayersampleandroid.domain.repository.VideosRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMovieRepository(videoService: VideoService): VideosRepository {
        return VideosRepositoryImpl(videoService = videoService)
    }
}