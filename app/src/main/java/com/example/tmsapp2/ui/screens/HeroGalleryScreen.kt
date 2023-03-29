package com.example.tmsapp2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.tmsapp2.model.HeroFactResponse

val myTestList = mutableListOf("tvjg", "jdjd", "fjdbsj", "sfjdnzjl", "cjshaislm")

@Composable
fun HeroGalleryScreen() {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ) {
        itemsIndexed(
            listOf(
                HeroFactResponse(1, "test1"),
                HeroFactResponse(2, "test2"),
                HeroFactResponse(3, "test3"),
                HeroFactResponse(4, "test4"),
                HeroFactResponse(5, "test5"),
                HeroFactResponse(6, "test6"),
                HeroFactResponse(7, "test7"),
            )
        ) { _, hero ->
            HeroItemCard(hero = hero)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HeroGalleryScreenPreview() {
    HeroGalleryScreen()
}