package com.github.nabin0.kmmvideoplayersampleandroid.domain.repository

import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideoItemResponse
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideosResponse
import com.github.nabin0.kmmvideoplayersampleandroid.utils.Resource

interface VideosRepository {
    suspend fun getVideoList(result: (Resource<VideosResponse?>) -> Unit)
    suspend fun getVideoById(id: Int, result: (Resource<VideoItemResponse?>) -> Unit)
}