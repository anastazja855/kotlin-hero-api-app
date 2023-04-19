package com.example.tmsapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tmsapp2.navigation.Screen
import com.example.tmsapp2.ui.screens.HeroDetailsScreen
import com.example.tmsapp2.ui.screens.HeroGalleryScreen
import com.example.tmsapp2.vm.HeroVm
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val heroViewModel: HeroVm by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            HeroNavigation(navController = navController)

        }
    }
}

@Composable
fun HeroNavigation(
    navController: NavHostController,
    viewModel: HeroVm = hiltViewModel()
) {

    NavHost(navController = navController, startDestination = Screen.HeroGallery.route) {
        composable(Screen.HeroGallery.route) {
            HeroGalleryScreen(navController = navController, viewModel = viewModel)
        }
        composable(
            Screen.HeroDetail.route,
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val heroId = backStackEntry.arguments?.getString("id") ?: ""
            HeroDetailsScreen(heroId = heroId.toInt(), navController = navController)
        }

    }

}


