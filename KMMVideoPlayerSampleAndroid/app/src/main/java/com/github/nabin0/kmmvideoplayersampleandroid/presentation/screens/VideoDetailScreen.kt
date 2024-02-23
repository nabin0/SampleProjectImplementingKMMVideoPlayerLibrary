package com.github.nabin0.kmmvideoplayersampleandroid.presentation.screens

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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.nabin0.kmmvideoplayer.controller.VideoPlayerControllerFactory
import com.github.nabin0.kmmvideoplayer.data.ClosedCaption
import com.github.nabin0.kmmvideoplayer.data.VideoItem
import com.github.nabin0.kmmvideoplayer.view.VideoPlayer
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables.ScreenLoadingCardShimmer
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.viewmodels.VideoViewModel

@Composable
fun VideoDetailScreen(videoId: Int) {
    val viewmodel: VideoViewModel = hiltViewModel()
    LaunchedEffect(Unit) {

        viewmodel.getVideoById(videoId)
    }

    val videoResponseState by viewmodel.videoItemResponsestate.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        videoResponseState?.let {
            VideoPlayerView(it, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(10.dp))
            VideoMetaDataLayout(videoItem = it)
        } ?: run {
            LazyColumn(Modifier.fillMaxSize()){
                item {
                    ScreenLoadingCardShimmer(imageHeight = 250.dp)
                    Spacer(modifier = Modifier.height(4.dp))
                    ScreenLoadingCardShimmer(imageHeight = 50.dp)
                    Spacer(modifier = Modifier.height(4.dp))
                    ScreenLoadingCardShimmer(imageHeight = 400.dp) }
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
    val videoPlayer = remember { VideoPlayerControllerFactory().createVideoPlayer() }
    Column(
        modifier = modifier,
    ) {
        VideoPlayer(
            modifier = Modifier.fillMaxWidth(),
            videoItem = videoItem,
            videoPlayerController = videoPlayer,
            listOfVideoUrls = null,
            startPlayMuted = false,
            setCCEnabled = true
        )
    }
}


val listOfVideoUrls = listOf(
    VideoItem(
        videoUrl = "https://v-msnprod.monumentalsportsnetwork.com/Renditions/20231127/1701124798032_download_msn_app_preview/dash/1701124798032_download_msn_app_preview.mpd",
        licenseUrl = "https://37eb8fe7.drm-widevine-licensing.axprod.net/AcquireLicense",
        licenseToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ2ZXJzaW9uIjoxLCJjb21fa2V5X2lkIjoiZWI5ZDU3NjMtNTc5OS00ZDA0LWI4NzgtYjAyOTAwYmFjNDUyIiwibWVzc2FnZSI6eyJ0eXBlIjoiZW50aXRsZW1lbnRfbWVzc2FnZSIsInZlcnNpb24iOjIsImxpY2Vuc2UiOnsiZHVyYXRpb24iOjkwMH0sImNvbnRlbnRfa2V5c19zb3VyY2UiOnsiaW5saW5lIjpbeyJpZCI6IjUyMGZmYWIwLTA4Y2ItNDhlMS04NDlhLTVmYjliYjg4YjA2NCIsInVzYWdlX3BvbGljeSI6IlBvbGljeSBBIn1dfSwiY29udGVudF9rZXlfdXNhZ2VfcG9saWNpZXMiOlt7Im5hbWUiOiJQb2xpY3kgQSIsInBsYXlyZWFkeSI6eyJtaW5fZGV2aWNlX3NlY3VyaXR5X2xldmVsIjoyMDAwLCJwbGF5X2VuYWJsZXJzIjpbIjc4NjYyN0Q4LUMyQTYtNDRCRS04Rjg4LTA4QUUyNTVCMDFBNyJdfSwid2lkZXZpbmUiOnsiZGV2aWNlX3NlY3VyaXR5X2xldmVsIjoiU1dfU0VDVVJFX0NSWVBUTyJ9fV19fQ.QfBjXZuL3EijeNhqJf88YyePaSow3TsK2S0TnjaNfTw",
        listOfClosedCaptions = null,
        title = null,
        videoDescription = null,
        isDrmEnabled = null,
        certificateUrl = null,
    ), VideoItem(
        videoUrl = "https://demo.unified-streaming.com/k8s/features/stable/video/tears-of-steel/tears-of-steel.ism/.m3u8",
        listOfClosedCaptions = listOf(
            ClosedCaption(
                subtitleLink = "https://cchoichoi.viewlift.com/2019/03/1552555747726_astey_ladies_ep_01_subs_final.srt",
                language = "english"
            )
        ),
        title = null,
        videoDescription = null,
        licenseToken = null,
        licenseUrl = null,
        isDrmEnabled = null,
        certificateUrl = null
    ), VideoItem(
        videoUrl = "https://bitmovin-a.akamaihd.net/content/sintel/hls/playlist.m3u8",
        title = null,
        videoDescription = null,
        licenseToken = null,
        licenseUrl = null,
        isDrmEnabled = null,
        certificateUrl = null
    ), VideoItem(
        videoUrl = "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        title = null,
        videoDescription = null,
        licenseToken = null,
        licenseUrl = null,
        isDrmEnabled = null,
        certificateUrl = null
    ), VideoItem(
        videoUrl = "https://media.istockphoto.com/id/1172642711/video/sea-wave-on-the-beach.mp4?s=mp4-640x640-is&k=20&c=WGMko95H0KBhKVIe519DF6_xeZtu1CdhiUHmK0D7Wy4=",
        title = null,
        videoDescription = null,
        licenseToken = null,
        licenseUrl = null,
        isDrmEnabled = null,
        certificateUrl = null
    ), VideoItem(
        videoUrl = "https://cdn.bitmovin.com/content/assets/art-of-motion_drm/mpds/11331.mpd",
        licenseUrl = "https://cwip-shaka-proxy.appspot.com/no_auth",
        title = null,
        videoDescription = null,
        licenseToken = null,
        isDrmEnabled = null,
        certificateUrl = null
    ), VideoItem(
        videoUrl = "https://devstreaming-cdn.apple.com/videos/streaming/examples/img_bipbop_adv_example_fmp4/master.m3u8",
        videoDescription = null,
        licenseToken = null,
        isDrmEnabled = null,
        certificateUrl = null
    )
)
