package com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideoItemResponse

@Composable
fun HorizontalPagerWithCircleRevealAnimation(
    list: List<VideoItemResponse>,
    navigateToVideoDetailScreen: (VideoItemResponse) -> Unit
) {
    CircleRevealPager(list = list, navigateToVideoDetailScreen)
}

@Composable
fun HorizontalCarousel(
    list: List<VideoItemResponse>,
    navigateToVideoDetailScreen: (VideoItemResponse) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        items(list) { item: VideoItemResponse ->
            CarouselVideoItemLayout(videoItemResponse = item, modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(0.7f)
                .padding(horizontal = 4.dp)
                .fillMaxHeight()
                .clickable { navigateToVideoDetailScreen.invoke(item) })
        }
    }
}

@Composable
fun ListVideoItems(
    list: List<VideoItemResponse>,
    navigateToVideoDetailScreen: (VideoItemResponse) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        userScrollEnabled = false
    ) {
        items(list) { item: VideoItemResponse ->
            ListVideoItemLayout(
                videoItemResponse = item,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .height(180.dp)
                    .clickable { navigateToVideoDetailScreen.invoke(item) })
        }
    }
}