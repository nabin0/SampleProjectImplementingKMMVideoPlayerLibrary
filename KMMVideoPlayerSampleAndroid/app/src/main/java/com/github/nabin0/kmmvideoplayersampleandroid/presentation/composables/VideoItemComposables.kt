package com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
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
import com.github.nabin0.kmmvideoplayersampleandroid.utils.Utils

@Composable
fun HorizontalPagerVideoItem(videoItemResponse: VideoItemResponse) {
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 35.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = videoItemResponse.title ?: "Unknown",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.White,
                    fontSize = 20.sp,
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

        Icon(
            imageVector = Icons.Filled.PlayArrow,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier.size(80.dp)
        )

    }
}

@Composable
fun CarouselVideoItemLayout(videoItemResponse: VideoItemResponse, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        AsyncImage(
            model = "https://source.unsplash.com/random/400x300?nature${videoItemResponse.id},landscape",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Black.copy(0.0f), Color.Black)

                    )
                )
        )
        Text(
            text = videoItemResponse.title ?: "Unknown",
            style = MaterialTheme.typography.headlineSmall.copy(
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Black,
            ),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
    }
}

@Composable
fun ListVideoItemLayout(videoItemResponse: VideoItemResponse, modifier: Modifier = Modifier) {

    Row(modifier = modifier) {
      Box(modifier = Modifier.fillMaxHeight().fillMaxWidth(0.45f)){
          AsyncImage(
              model = "https://source.unsplash.com/random/200x200?nature${videoItemResponse.id},landscape",
              contentDescription = null,
              contentScale = ContentScale.Crop,
              placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
              modifier = Modifier.fillMaxHeight()
          )

          Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "", modifier = Modifier.align(
              Alignment.BottomStart).padding(2.dp).size(40.dp))
      }

        Column(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(start = 8.dp, end = 4.dp), verticalArrangement = Arrangement.Center) {
            Text(
                text = videoItemResponse.title ?: "Unknown",
                style = MaterialTheme.typography.headlineSmall.copy(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black,
                ),
                maxLines = 2
            )

            Text(
                text = Utils.getFormattedDateTime(),
                style = MaterialTheme.typography.bodySmall.copy(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Black,
                ),
                modifier = Modifier.padding(vertical = 8.dp).clip(RoundedCornerShape(50)).background(Color.Gray.copy(0.2f)).padding(6.dp)
            )


        }


    }
}



@Preview(showBackground = true, uiMode = 1)
@Composable
fun PreviewHorizontalCarouselVideoItem() {
    CarouselVideoItemLayout(
        videoItemResponse = VideoItemResponse(
            certificateUrl = null,
            id = 1,
            isDrmEnabled = false,
            licenseToken = null,
            videoUrl = "url",
            licenseUrl = null,
            listOfClosedCaptions = null,
            title = "nulladkjfi ",
            videoDescription = "desc"
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    )
}@Preview(showBackground = true, uiMode = 1)
@Composable
fun PreviewListVideoItem() {
    ListVideoItemLayout(
        videoItemResponse = VideoItemResponse(
            certificateUrl = null,
            id = 1,
            isDrmEnabled = false,
            licenseToken = null,
            videoUrl = "url",
            licenseUrl = null,
            listOfClosedCaptions = null,
            title = "Video title goes here lorem epsum",
            videoDescription = "desc heree"
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
    )
}