package com.github.nabin0.kmmvideoplayersampleandroid.utils

import com.github.nabin0.kmmvideoplayer.controller.VideoPlayerControllerFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object Utils {
    val playerController = VideoPlayerControllerFactory().createVideoPlayer()

    fun getFormattedDateTime(): String{
        val currentDate = Date()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(currentDate)
    }
}