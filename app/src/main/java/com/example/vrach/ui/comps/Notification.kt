package com.example.vrach.ui.comps

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun Notification(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxHeight()
    ) {
        Icon(
            imageVector = Icons.Outlined.Notifications,
            contentDescription = "",
            modifier = modifier,
            tint = Color.Gray
        )
        Spacer(modifier = Modifier.width(1.dp))
        Icon(
            imageVector = Icons.Outlined.FavoriteBorder,
            contentDescription = "",
            modifier = modifier.size(1.dp),
            tint = Color.Gray
        )
    }
}
