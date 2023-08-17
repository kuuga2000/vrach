package com.example.vrach.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.vrach.ui.comps.CustomSearchField
import com.example.vrach.ui.comps.Notification
import com.example.vrach.ui.home.components.Greeting
import com.example.vrach.ui.home.components.HomeBannerSlider

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
        Spacer(modifier = Modifier.height(20.dp))
        HomeBannerSlider()
    }
}
