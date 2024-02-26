package com.github.nabin0.kmmvideoplayersampleandroid.presentation.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.github.nabin0.kmmvideoplayersampleandroid.data.model.VideoItemResponse
import kotlin.math.absoluteValue
import kotlin.math.sqrt

@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun CircleRevealPager(
    list: List<VideoItemResponse>,
    navigateToVideoDetailScreen: (VideoItemResponse,  currentVideoItemIndex: Int?) -> Unit
) {
    val state = rememberPagerState {
        list.size
    }
    var offsetY by remember { mutableFloatStateOf(0f) }

    var pageIndex by remember {
        mutableStateOf(-1)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.5f)
            .clickable {
                if (pageIndex != -1)
                    navigateToVideoDetailScreen.invoke(list[state.currentPage], null)
            }
    ) {
        HorizontalPager(
            modifier = Modifier
                .pointerInteropFilter {
                    offsetY = it.y
                    false
                }
                .padding(horizontal = 4.dp, vertical = 4.dp)
                .clip(
                    RoundedCornerShape(16.dp)
                ),
            state = state,
        ) { page ->
            pageIndex = page
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        val pageOffset = state.getOffsetFractionForPage(page)
                        translationX = size.width * pageOffset

                        val endOffset = state.getOffsetFractionForPage(page)
                        val a = if (endOffset >= 0) 0f else endOffset.absoluteValue
                        shadowElevation = 20f
                        shape = CirclePath(
                            progress = 1f - a,
                            origin = Offset(
                                size.width,
                                offsetY,
                            )
                        )
                        clip = true

                        val absoluteOffset = state.getOffsetFractionForPage(page)
                        val scale = 1f + (absoluteOffset.absoluteValue * .4f)

                        scaleX = scale
                        scaleY = scale

                        val startOffset = state.currentPageOffsetFraction
                        alpha = (2f - startOffset) / 2f

                    },
                contentAlignment = Alignment.Center,
            ) {
                HorizontalPagerVideoItem(videoItemResponse = list[page])
            }
        }

        //Horizontal pager indicator
        Row(
            Modifier
                .height(30.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(list.size) { iteration ->
                val color =
                    if (state.currentPage == iteration) Color.White else Color.White.copy(
                        alpha = 0.4f
                    )
                Box(
                    modifier = Modifier
                        .padding(3.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(12.dp)

                )
            }
        }
    }

}

class CirclePath(private val progress: Float, private val origin: Offset = Offset(0f, 0f)) : Shape {
    override fun createOutline(
        size: Size, layoutDirection: LayoutDirection, density: Density
    ): Outline {

        val center = Offset(
            x = size.center.x - ((size.center.x - origin.x) * (1f - progress)),
            y = size.center.y - ((size.center.y - origin.y) * (1f - progress)),
        )
        val radius = (sqrt(
            size.height * size.height + size.width * size.width
        ) * .5f) * progress

        return Outline.Generic(Path().apply {
            addOval(
                Rect(
                    center = center,
                    radius = radius,
                )
            )
        })
    }
}
