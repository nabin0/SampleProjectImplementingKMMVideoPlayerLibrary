package com.github.nabin0.kmmvideoplayersampleandroid.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.nabin0.kmmvideoplayer.controller.VideoPlayerControllerFactory
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideoItemResponse
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideosResponse
import com.github.nabin0.kmmvideoplayersampleandroid.domain.repository.VideosRepository
import com.github.nabin0.kmmvideoplayersampleandroid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(private val videosRepository: VideosRepository) :
    ViewModel() {

    val videoPlayerController = VideoPlayerControllerFactory().createVideoPlayer()

    private val _videoList: MutableStateFlow<VideosResponse?> = MutableStateFlow(null)
    val videoList = _videoList.asStateFlow()

    var currentSelectedVideo: MutableStateFlow<VideoItemResponse?> = MutableStateFlow(null)

    var videoItem = videoList.value?.get(0)

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean>
        get() = _isLoading.asStateFlow()

    init {
        getVideoList()
    }

    fun getVideoList() {

        viewModelScope.launch(Dispatchers.IO) {
            videosRepository.getVideoList { response ->
                when (response) {
                    is Resource.Failure -> {
                        Log.d("TAG", "getVideoList failure: ${response.exception.toString()}")
                    }

                    Resource.Loading -> {
                        _isLoading.value = true
                        Log.d("TAG", "loading")
                    }

                    is Resource.Success -> {
                        _isLoading.value = false
                        _videoList.value = response.result
                        Log.d("TAG", "getVideoList success: ${videoList.value}")
                    }
                }
            }
        }

    }


    fun getCurrentVideoById(videoId: Int) {
        videoList.value?.let { videoResponse ->
            currentSelectedVideo.value = videoResponse.find {
                it.id == videoId
            }
            videoItem = currentSelectedVideo.value
        }
    }
}