package com.example.tmsapp2.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tmsapp2.model.HeroFactResponse

@Composable
fun HeroItemCard(hero: HeroFactResponse) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .background(Color.Magenta)

    ) {
        Text(text = hero.name)
        Text(text = hero._id.toString())
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HeroItemCardPreview() {
//    HeroItemCard(hero = HeroFactResponse(1,"sdfsd"))
//}