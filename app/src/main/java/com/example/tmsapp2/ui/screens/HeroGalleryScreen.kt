package com.example.tmsapp2.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.tmsapp2.arch.UiState
import com.example.tmsapp2.ui.theme.TMSApp2Theme
import com.example.tmsapp2.vm.HeroVm


@Composable
fun HeroGalleryScreen(navController: NavController,
                      viewModel: HeroVm = hiltViewModel()
) {
    TMSApp2Theme {
        androidx.compose.material.Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val state = viewModel.state.observeAsState()
            when (val uiState = state.value) {
                is UiState.Loading -> {
                    // Show loading indicator
                    CircularProgressIndicator(
                        modifier = Modifier.size(100.dp),
                        color = Color.Green,
                        strokeWidth = 10.dp
                    )
                }
                is UiState.Error -> {
                    // Show error message
                    Text(text = "Failed to load hero facts")
                }
                is UiState.HeroLoaded -> {
                    // Fetch the hero data
                    viewModel.getHeroArray(1)

                    // Show the list of characters
                    val heroes = uiState.heroFacts

                    LazyColumn(content = {
                        items(heroes) { hero ->
                            HeroItemCard(hero = hero)
                        }
                    })
                }
            }


        }
    }
}

@Preview
@Composable
fun PrevHeroGalleryScreen() {

}


