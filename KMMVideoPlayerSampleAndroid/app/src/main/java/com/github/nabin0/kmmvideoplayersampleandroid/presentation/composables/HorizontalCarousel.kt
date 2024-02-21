package com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables

import androidx.compose.runtime.Composable
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideoItemResponse

@Composable
fun HorizontalCarousel(list: List<VideoItemResponse>) {
    CircleRevealPager(list = list)
}

