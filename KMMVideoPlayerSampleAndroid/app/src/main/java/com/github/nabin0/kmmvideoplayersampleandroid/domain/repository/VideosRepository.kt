package com.github.nabin0.kmmvideoplayersampleandroid.domain.repository

import com.github.nabin0.kmmvideoplayer.data.VideoItem
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideosResponse
import com.github.nabin0.kmmvideoplayersampleandroid.utils.Resource

interface VideosRepository {
    suspend fun getVideoList(result: (Resource<VideosResponse?>) -> Unit)
    suspend fun getVideoById(id: Int, result: (Resource<VideoItem?>) -> Unit)
}