package com.example.vrach.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.vrach.ui.comps.CustomSearchField
import com.example.vrach.ui.comps.Notification
import com.example.vrach.ui.home.components.CarouselSlider
import com.example.vrach.ui.home.components.Greeting
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier
) {
    var searchKeyword by remember {
        mutableStateOf("")
    }

    Column(
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Greeting()
            Notification(
                modifier = Modifier
                    .width(25.dp)
                    .height(25.dp)
            )
        }
        CustomSearchField(search = searchKeyword, onValueChange = { searchKeyword = it } )
        val images = listOf(
            "https://via.placeholder.com/300x200.png?text=Image+1",
            "https://via.placeholder.com/300x200.png?text=Image+2",
            "https://via.placeholder.com/300x200.png?text=Image+3"
        )

        Card(
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            CarouselSlider(
                itemsCount = images.size,
                itemContent = { index ->
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(images[index])
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.height(200.dp)
                    )
                }
            )
        }
    }
}
