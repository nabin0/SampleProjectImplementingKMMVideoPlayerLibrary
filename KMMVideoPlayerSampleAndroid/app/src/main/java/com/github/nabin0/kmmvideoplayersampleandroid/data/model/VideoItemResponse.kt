package com.github.nabin0.kmmvideoplayersampleandroid.data.model

data class VideoItemResponse(
    val certificateUrl: Any,
    val id: Int,
    val isDrmEnabled: Boolean,
    val licenseToken: Any,
    val licenseUrl: String,
    val listOfClosedCaptions: List<ClosedCaptions>,
    val title: String,
    val videoDescription: String,
    val videoUrl: String
)