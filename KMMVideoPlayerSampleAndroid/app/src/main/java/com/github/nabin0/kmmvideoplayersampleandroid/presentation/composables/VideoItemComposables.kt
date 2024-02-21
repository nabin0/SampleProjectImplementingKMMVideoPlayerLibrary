package com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.github.nabin0.kmmvideoplayersampleandroid.R
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideoItemResponse

@Composable
fun HorizontalCarousalVideoItem(videoItemResponse: VideoItemResponse) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        AsyncImage(
            model = "https://source.unsplash.com/random/400x300?nature${videoItemResponse.id},landscape",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .fillMaxHeight(.8f)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Black.copy(alpha = 0f),
                            Color.Black.copy(alpha = 0.8f),
                        )
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 35.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = videoItemResponse.title ?: "Unknown",
                style = MaterialTheme.typography.headlineMedium.copy(
                    color = Color.White,
                    fontSize = 22.sp,
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
                text = videoItemResponse.videoDescription?.substring(
                    0,
                    minOf(videoItemResponse.videoDescription.length - 1, 100)
                ) ?: "Video description not available",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.White,
                    fontSize = 14.sp,
                    lineHeight = 22.sp,
                )
            )
        }

        IconButton(onClick = {

        }, modifier = Modifier
            .align(Alignment.Center)
            .size(80.dp)) {
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(80.dp)
            )
        }
    }
}

@Preview(showBackground = true, uiMode = 1)
@Composable
fun PreviewHorizontalCarousalVideoItem() {
    HorizontalCarousalVideoItem(
        videoItemResponse = VideoItemResponse(
            certificateUrl = null,
            id = 1,
            isDrmEnabled = false,
            licenseToken = null,
            videoUrl = "url",
            licenseUrl = null,
            listOfClosedCaptions = null,
            title = "null",
            videoDescription = "desc"
        )
    )
}