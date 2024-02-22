package com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideoItemResponse

@Composable
fun HorizontalPagerWithCircleRevealAnimation(list: List<VideoItemResponse>, navigateToVideoDetailScreen:(VideoItemResponse) -> Unit) {
    CircleRevealPager(list = list, navigateToVideoDetailScreen)
}

@Composable
fun HorizontalCarousel(list: List<VideoItemResponse>,navigateToVideoDetailScreen:(VideoItemResponse) -> Unit) {
    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)){
        items(list){item: VideoItemResponse ->
            Column {

            }
            CarouselVideoItemLayout(videoItemResponse = item, modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight())
        }
    }
}



@Preview(showBackground = true, uiMode = 1)
@Composable
fun PreviewHorizontalCarousel() {

    val list = List(20){
        VideoItemResponse(
            certificateUrl = null,
            id = 1,
            isDrmEnabled = false,
            licenseToken = null,
            videoUrl = "url",
            licenseUrl = null,
            listOfClosedCaptions = null,
            title = "nulladkjfi ",
            videoDescription = "desc"
        )
    }
    HorizontalCarousel(
        list = list
    ) {

    }
}