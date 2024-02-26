package com.github.nabin0.kmmvideoplayersampleandroid.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.nabin0.kmmvideoplayer.data.VideoItem
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideoItemResponse
import com.github.nabin0.kmmvideoplayersampleandroid.domain.repository.VideosRepository
import com.github.nabin0.kmmvideoplayersampleandroid.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class VideoByIdViewModels @Inject constructor(private val videosRepository: VideosRepository) :
    ViewModel() {

    var videoItemResponse: VideoItem? = null
    var videoItemResponsestate: MutableStateFlow<VideoItem?> = MutableStateFlow(null)

    val resultState = MutableStateFlow(0)

    fun getVideoById(id: Int) {
        viewModelScope.launch {
            videosRepository.getVideoById(id) { response ->
                when (response) {
                    is Resource.Failure -> {
                        resultState.value = 0
                    }

                    Resource.Loading -> {
                        resultState.value = 1
                    }

                    is Resource.Success -> {
                        resultState.value = 2
                        Log.d("TAG", "getVideoById: ")
                        val result = response.result
                        result?.let {
                            val videoItem = VideoItem(
                                id = it.id,
                                videoUrl = it.videoUrl,
                                licenseUrl = it.licenseUrl,
                                licenseToken = it.licenseToken,
                                listOfClosedCaptions = null,
                                title = null,
                                videoDescription = null,
                                isDrmEnabled = null,
                                certificateUrl = it.certificateUrl,
                            )
                            videoItemResponse = videoItem

                            videoItemResponsestate.value = videoItem
                        }

                    }
                }
            }
        }
    }
}