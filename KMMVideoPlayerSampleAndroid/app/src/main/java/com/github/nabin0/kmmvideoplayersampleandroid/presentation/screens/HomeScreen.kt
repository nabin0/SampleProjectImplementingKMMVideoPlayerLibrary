package com.github.nabin0.kmmvideoplayersampleandroid.presentation.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocalFireDepartment
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideoItemResponse
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables.HorizontalCarousel
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables.HorizontalPagerWithCircleRevealAnimation
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables.ListVideoItemLayout
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables.ScreenLoadingCardShimmer
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables.TextWithLeadingIcon
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.viewmodels.VideoViewModel

@Composable
fun HomeScreen(
    navigateToVideoDetailScreen: (VideoItemResponse, currentVideoItemIndex: Int?) -> Unit
) {

    val videoViewModel: VideoViewModel = hiltViewModel()
    val videoList by videoViewModel.videoList.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize(), state = rememberLazyListState()
    ) {
        item {
            videoList?.let {
                HorizontalPagerWithCircleRevealAnimation(
                    list = it, navigateToVideoDetailScreen
                )

                Spacer(modifier = Modifier.height(16.dp))
                TextWithLeadingIcon(
                    icon = Icons.Filled.Favorite,
                    iconTint = Color.Red,
                    iconSize = 35,
                    text = "Recommended For You",
                    textColor = Color.Black,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize()
                )
                HorizontalCarousel(
                    list = it, navigateToVideoDetailScreen = navigateToVideoDetailScreen
                )

            } ?: run {
                ScreenLoadingCardShimmer(imageHeight = 300.dp)
                Spacer(modifier = Modifier.height(8.dp))
                ScreenLoadingCardShimmer(imageHeight = 50.dp)
                Spacer(modifier = Modifier.height(8.dp))
                ScreenLoadingCardShimmer(imageHeight = 300.dp)
                Spacer(modifier = Modifier.height(8.dp))
                ScreenLoadingCardShimmer(imageHeight = 50.dp)
            }
        }

        videoList?.let {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                TextWithLeadingIcon(
                    icon = Icons.Filled.LocalFireDepartment,
                    iconTint = Color((0xffaa4203)),
                    iconSize = 35,
                    text = "Trending",
                    textColor = Color.Black,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize()
                )
            }
            itemsIndexed(it) { index,item: VideoItemResponse ->
                ListVideoItemLayout(videoItemResponse = item,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .height(140.dp)
                        .clickable { navigateToVideoDetailScreen.invoke(item, index) })
            }
        } ?: run {
            item {
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(5) {
                ScreenLoadingCardShimmer(imageHeight = 150.dp)
                Spacer(modifier = Modifier.height(15.dp))
            }
        }
    }
}