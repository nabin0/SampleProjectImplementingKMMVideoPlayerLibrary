package com.github.nabin0.kmmvideoplayersampleandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.github.nabin0.kmmvideoplayer.controller.VideoPlayerControllerFactory
import com.github.nabin0.kmmvideoplayer.data.ClosedCaption
import com.github.nabin0.kmmvideoplayer.data.VideoItem
import com.github.nabin0.kmmvideoplayer.view.VideoPlayer
import com.github.nabin0.kmmvideoplayersampleandroid.ui.theme.KMMVideoPlayerSampleAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KMMVideoPlayerSampleAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val videoPlayer =
                        remember { VideoPlayerControllerFactory().createVideoPlayer() }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        VideoPlayer(
                            modifier = Modifier.fillMaxWidth(),
                            videoItem = VideoItem(
                                videoUrl = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8",
                                listOfClosedCaptions = listOf(
                                    ClosedCaption(
                                        subtitleLink = "https://cchoichoi.viewlift.com/2019/03/1552555747726_astey_ladies_ep_01_subs_final.srt",
                                        language = "english"
                                    )
                                ),
                                title = null, videoDescription = null,
                                licenseToken = null,
                                licenseUrl = null,
                                isDrmEnabled = null,
                                certificateUrl = null
                            ),
                            videoPlayerController = videoPlayer,
                            listOfVideoUrls = null,
                            startPlayMuted = false,
                            setCCEnabled = true
                        )
                    }

                }
            }
        }
    }
}