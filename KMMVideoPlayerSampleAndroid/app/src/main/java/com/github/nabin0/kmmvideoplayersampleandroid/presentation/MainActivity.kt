package com.github.nabin0.kmmvideoplayersampleandroid.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.screens.HomeScreen
import com.github.nabin0.kmmvideoplayersampleandroid.presentation.screens.VideoDetailScreen
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
                    MainNavGraph(navHostController = rememberNavController())
                }
            }
        }
    }
}


@Composable
fun MainNavGraph(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Screens.HomeScreen.route) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen( navigateToVideoDetailScreen = { videoId, currentVideoItemIndexInList ->
                navHostController.navigate(
                    Screens.VideoDetailScreen.route.replace(
                        "{VIDEO_ID}",
                        videoId.id.toString()
                    ).replace("{ITEM_INDEX}", currentVideoItemIndexInList.toString())
                )
            })
        }

        composable(route = Screens.VideoDetailScreen.route) { backStackEntry ->
            val videoId = backStackEntry.arguments?.getString("VIDEO_ID")?.toInt() ?: 0
            val itemIndexValue = backStackEntry.arguments?.getString("ITEM_INDEX")
            var itemIndex: Int? = null
            if(itemIndexValue != "null"){
                itemIndex = itemIndexValue?.toInt()
            }
            VideoDetailScreen(videoId = videoId, itemIndex)
        }
    }
}


sealed class Screens(val route: String) {
    data object HomeScreen : Screens("home")
    data object VideoDetailScreen : Screens("videoDetail/{VIDEO_ID}/{ITEM_INDEX}")
}