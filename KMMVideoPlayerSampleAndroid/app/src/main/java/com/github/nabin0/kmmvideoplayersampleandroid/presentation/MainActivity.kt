package com.github.nabin0.kmmvideoplayersampleandroid.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.nabin0.kmmvideoplayer.controller.VideoPlayerControllerFactory
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables.CircleRevealPager
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables.HorizontalCarousel
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.viewmodels.VideoViewModel
import com.github.nabin0.kmmvideoplayersampleandroid.ui.theme.KMMVideoPlayerSampleAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KMMVideoPlayerSampleAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val videoViewModel: VideoViewModel = hiltViewModel()
                    videoViewModel.getVideoList()
                    val videoPlayer =remember { VideoPlayerControllerFactory().createVideoPlayer() }

                    val videoList by videoViewModel.videoList.collectAsState()
                    Column(
                        modifier = Modifier.fillMaxSize(),
                    ) {

                        videoList?.let { HorizontalCarousel(list = it) }

//                        VideoPlayer(
//                            modifier = Modifier.fillMaxWidth(),
//                            videoItem = VideoItem(
//                                videoUrl = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8",
//                                listOfClosedCaptions = listOf(
//                                    ClosedCaption(
//                                        subtitleLink = "https://cchoichoi.viewlift.com/2019/03/1552555747726_astey_ladies_ep_01_subs_final.srt",
//                                        language = "english"
//                                    )
//                                ),
//                                title = null,
//                                videoDescription = null,
//                                licenseToken = null,
//                                licenseUrl = null,
//                                isDrmEnabled = null,
//                                certificateUrl = null
//                            ),
//                            videoPlayerController = videoPlayer,
//                            listOfVideoUrls = null,
//                            startPlayMuted = false,
//                            setCCEnabled = true
//                        )
                    }

                }
            }
        }
    }
}
