package com.example.vrach.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.vrach.R

@Composable
fun Greeting(
    textGreeting: String = "Welcome!",
    textCustomerFullName: String = "Beloved Customer",
    onAvatarClicked: () -> Unit = {}
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Avatar(
            onAvatarClicked = onAvatarClicked
        )
        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text(text = textGreeting, color = Color.Gray)
            Text(text = textCustomerFullName, color = Color(0xFFF2c2c2c),fontWeight = FontWeight.SemiBold)
        }
    }
}

@Composable
fun Avatar(
    onAvatarClicked: () -> Unit
) {
    Image(
        painter = painterResource(id = R.drawable.nkimdz8a), contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(60.dp)
            .clip(CircleShape)
            .clickable(
                onClick = onAvatarClicked
            )
    )
}
