package com.github.nabin0.kmmvideoplayersampleandroid.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.nabin0.kmmvideoplayer.data.VideoItem
import com.github.nabin0.kmmvideoplayer.view.VideoPlayer
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables.ScreenLoadingCardShimmer
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.viewmodels.VideoViewModel
import com.github.nabin0.kmmvideoplayersampleandroid.utils.Utils

@Composable
fun VideoDetailScreen(videoId: Int, currentVideoItemIndex: Int?) {
    val viewmodel: VideoViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewmodel.getVideoById(videoId)
    }

//    val index = viewmodel.index.collectAsState()
//    LaunchedEffect(index) {
//        Log.d("TAG", "VideoPlayerWithPlaylist: $currentVideoItemIndex")
//    }

    val videoResponse by viewmodel.videoItemMutableStateFlow.collectAsState()
    val videoList by viewmodel.videoList.collectAsState()


    Column(modifier = Modifier.fillMaxSize()) {
        videoResponse?.let {
            if (currentVideoItemIndex != null) {
                viewmodel.getVideoItemListFromVideoResponseList(videoList)
                    ?.let { it1 ->
                        VideoPlayerWithPlaylist(
                            videoList = it1,
                            currentVideoItemIndexInList = currentVideoItemIndex
                        )
                    }
            } else
                VideoPlayerView(it, modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(10.dp))
            VideoMetaDataLayout(videoItem = it)
        } ?: run {
            LazyColumn(Modifier.fillMaxSize()) {
                item {
                    ScreenLoadingCardShimmer(imageHeight = 250.dp)
                    Spacer(modifier = Modifier.height(4.dp))
                    ScreenLoadingCardShimmer(imageHeight = 50.dp)
                    Spacer(modifier = Modifier.height(4.dp))
                    ScreenLoadingCardShimmer(imageHeight = 400.dp)
                }
            }
        }
    }
}

@Composable
fun VideoMetaDataLayout(videoItem: VideoItem) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = videoItem.title ?: "Unknown",
            style = MaterialTheme.typography.headlineMedium.copy(
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Black,
            )
        )

        Spacer(
            modifier = Modifier
                .padding(vertical = 4.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.White)
        )
        Text(
            text = videoItem.videoDescription ?: "Video description not available",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Color.Black,
                fontSize = 16.sp,
                lineHeight = 22.sp,
            )
        )
    }
}


@Composable
fun VideoPlayerView(videoItem: VideoItem, modifier: Modifier = Modifier) {
    val videoPlayer = Utils.playerController
    Column(
        modifier = modifier,
    ) {
        VideoPlayer(
            modifier = Modifier.fillMaxWidth(),
            videoItem = videoItem,
            videoPlayerController = videoPlayer,
            listOfVideoUrls = null,
            startPlayMuted = false,
            setCCEnabled = true,
            currentVideoItemIndexInList = null
        )
    }
}

@Composable
fun VideoPlayerWithPlaylist(
    videoList: List<VideoItem>,
    currentVideoItemIndexInList: Int,
    modifier: Modifier = Modifier
) {
    val videoPlayer = Utils.playerController

    Column(
        modifier = modifier,
    ) {
        VideoPlayer(
            modifier = Modifier.fillMaxWidth(),
            videoItem = null,
            videoPlayerController = videoPlayer,
            listOfVideoUrls = videoList,
            startPlayMuted = false,
            setCCEnabled = true,
            currentVideoItemIndexInList = currentVideoItemIndexInList
        )
    }
}
