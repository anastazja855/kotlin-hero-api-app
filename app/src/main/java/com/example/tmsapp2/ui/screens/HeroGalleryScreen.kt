package com.example.tmsapp2.ui.screens

import android.provider.ContactsContract
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.request.RequestOptions
import com.example.tmsapp2.R
import com.example.tmsapp2.arch.UiState
import com.example.tmsapp2.ui.theme.TMSApp2Theme
import com.example.tmsapp2.vm.HeroVm
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun HeroGalleryScreen(navController: NavController,
                      viewModel: HeroVm = hiltViewModel()
) {
    TMSApp2Theme {
        androidx.compose.material.Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            val state = viewModel.state.observeAsState()
            Column() {
                UserFavoriteHeroes()

                Row(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {


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

                            LazyColumn(
                                contentPadding = PaddingValues(
                                    horizontal = 16.dp,
                                    vertical = 8.dp
                                )
                            ) {
                                items(heroes) { hero ->
                                    HeroItemCard(hero = hero)
                                }
                            }
                        }


                    }
                }
            }
        }
    }
}

@Composable
fun UserFavoriteHeroes() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
    ) {


        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.3f)
                .fillMaxHeight(0.5f)
        ) {
            Button(
                onClick = { /* Handle click on button 1 */ },
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                Icon(
                    Icons.Filled.ShoppingCart,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("All")
            }

            Button(
                onClick = { /* Handle click on button 2 */ },
                contentPadding = PaddingValues(
                    start = 20.dp,
                    top = 12.dp,
                    end = 20.dp,
                    bottom = 12.dp
                )
            ) {
                // Inner content including an icon and a text label
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("My")
            }
        }
        GlideImage(
            imageModel = "https://static.wikia.nocookie.net/disney/images/5/51/Giffany.png",
            contentScale = ContentScale.Crop,
            contentDescription = "My image",
            modifier = Modifier
                .padding(16.dp)
                .fillMaxHeight()
                .fillMaxHeight(0.2f)
        )
    }

}




