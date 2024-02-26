package com.github.nabin0.kmmvideoplayersampleandroid.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.nabin0.kmmvideoplayer.controller.VideoPlayerControllerFactory
import com.github.nabin0.kmmvideoplayer.data.ClosedCaption
import com.github.nabin0.kmmvideoplayer.data.VideoItem
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideoItemResponse
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideosResponse
import com.github.nabin0.kmmvideoplayersampleandroid.domain.repository.VideosRepository
import com.github.nabin0.kmmvideoplayersampleandroid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
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
        Log.d("TAG", ":viewmodle called initl() ")
        getVideoList()
    }

    var videoItemResponsestate: MutableStateFlow<VideoItem?> = MutableStateFlow(null)
    var videoItemResponse: MutableStateFlow<VideoItemResponse?> = MutableStateFlow(null)

    fun getVideoById(id: Int) {
        viewModelScope.launch {
            delay(700)
            videosRepository.getVideoById(id) { response ->
                when (response) {
                    is Resource.Failure -> {
                    }

                    Resource.Loading -> {
                    }

                    is Resource.Success -> {
                        val result = response.result
                        result?.let { itemResponse ->
                            val listOfClosedCaption = itemResponse.listOfClosedCaptions?.map {
                                ClosedCaption(language = it.language, subtitleLink = it.subtitleLink)
                            }
                            videoItemResponse.value = itemResponse
                            val videoItem = VideoItem(
                                id = itemResponse.id,
                                videoUrl = itemResponse.videoUrl,
                                licenseUrl = itemResponse.licenseUrl,
                                licenseToken = itemResponse.licenseToken,
                                listOfClosedCaptions = listOfClosedCaption,
                                title = itemResponse.title,
                                videoDescription = itemResponse.videoDescription,
                                isDrmEnabled = itemResponse.isDrmEnabled,
                                certificateUrl = itemResponse.certificateUrl,
                            )
                            videoItemResponsestate.value = videoItem
                        }
                    }
                }
            }
        }
    }


    fun getVideoItemListFromVideoResponseList(list: VideosResponse?): List<VideoItem>? {
        return list?.map { itemResponse ->
            val listOfClosedCaption = itemResponse.listOfClosedCaptions?.map {
                ClosedCaption(language = it.language, subtitleLink = it.subtitleLink)
            }
            VideoItem(
                id = itemResponse.id,
                videoUrl = itemResponse.videoUrl,
                licenseUrl = itemResponse.licenseUrl,
                licenseToken = itemResponse.licenseToken,
                listOfClosedCaptions = listOfClosedCaption,
                title = itemResponse.title,
                videoDescription = itemResponse.videoDescription,
                isDrmEnabled = itemResponse.isDrmEnabled,
                certificateUrl = itemResponse.certificateUrl,
            )
        }
    }

    private fun getVideoList() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(700)

            videosRepository.getVideoList { response ->
                when (response) {
                    is Resource.Failure -> {
                        Log.d("TAG", "getVideoList failure: ${response.exception.toString()}")
                    }

                    Resource.Loading -> {
                        _isLoading.value = true
                    }

                    is Resource.Success -> {
                        _isLoading.value = false
                        _videoList.value = response.result
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