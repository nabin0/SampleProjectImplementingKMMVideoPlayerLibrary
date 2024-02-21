package com.github.nabin0.kmmvideoplayersampleandroid.data.model

data class VideoItemResponse(
    val certificateUrl: String?,
    val id: Int,
    val isDrmEnabled: Boolean?,
    val licenseToken: String?,
    val licenseUrl: String?,
    val listOfClosedCaptions: List<ClosedCaptions>?,
    val title: String?,
    val videoDescription: String?,
    val videoUrl: String
)