package com.github.nabin0.kmmvideoplayersampleandroid.data.repository

import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideoItemResponse
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideosResponse
import com.github.nabin0.kmmvideoplayersampleandroid.data.network.VideoService
import com.github.nabin0.kmmvideoplayersampleandroid.domain.repository.VideosRepository
import com.github.nabin0.kmmvideoplayersampleandroid.utils.Resource

class VideosRepositoryImpl(
    private val videoService: VideoService
) : VideosRepository {
    override suspend fun getVideoList(result: (Resource<VideosResponse?>) -> Unit) {
        result.invoke(Resource.Loading)
        try {
            val response = videoService.getVideos()
            val body = response.body()
            result.invoke(Resource.Success(body))
        } catch (e: Exception) {
            e.printStackTrace()
            result.invoke(Resource.Failure(e))
        }
    }

    override suspend fun getVideoById(id: Int, result: (Resource<VideoItemResponse?>) -> Unit) {
        result.invoke(Resource.Loading)
        try {
            val response = videoService.getVideoById(id)
            val body = response.body()
            result.invoke(Resource.Success(body))
        } catch (e: Exception) {
            e.printStackTrace()
            result.invoke(Resource.Failure(e))
        }
    }

}