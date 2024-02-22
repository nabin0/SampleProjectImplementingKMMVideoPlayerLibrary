package com.github.nabin0.kmmvideoplayersampleandroid.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideoItemResponse
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables.HorizontalPagerWithCircleRevealAnimation
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.viewmodels.VideoViewModel

@Composable
fun HomeScreen(
    videoViewModel: VideoViewModel,
    navigateToVideoDetailScreen: (VideoItemResponse) -> Unit
) {
    val videoList by videoViewModel.videoList.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(enabled = true, state = rememberScrollState())) {
        videoList?.let { HorizontalPagerWithCircleRevealAnimation(list = it, navigateToVideoDetailScreen) }



    }

}