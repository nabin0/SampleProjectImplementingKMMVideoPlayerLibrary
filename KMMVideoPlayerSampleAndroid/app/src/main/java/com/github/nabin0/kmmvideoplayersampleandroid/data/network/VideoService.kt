package com.github.nabin0.kmmvideoplayersampleandroid.data.network

import com.github.nabin0.kmmvideoplayer.data.VideoItem
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideosResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface VideoService {
    @GET("videos")
    suspend fun getVideos(): Response<VideosResponse>

    @GET("videos/{id}")
    suspend fun getVideoById(
        @Path("id") id:Int
    ): Response<VideoItem>

    companion object {
        const val BASE_URL = "http://nabin0.pythonanywhere.com/"
    }
}