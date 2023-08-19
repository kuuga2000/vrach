package com.example.vrach.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.vrach.R

val specialityList = mapOf(
    0 to R.drawable.people_svgrepo_com,
    1 to R.drawable.tooth_svgrepo_com,
    2 to R.drawable.eye_svgrepo_com,
    3 to R.drawable.nutrition_svgrepo_com,
    4 to R.drawable.neurology_svgrepo_com,
    5 to R.drawable.pediatrics_svgrepo_com,
    6 to R.drawable.i_radiology_svgrepo_com,
    7 to R.drawable.more_horizontal_circle_svgrepo_com
)

val specialityDesc = listOf(
    "General",
    "Dentist",
    "Ophthalmic",
    "Nutritionist",
    "Neurology",
    "Pediatric",
    "Radiologist",
    "More",
)

@Composable
fun Speciality() {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Doctor Speciality", color = Color.Black, fontWeight = FontWeight.Bold)
            ClickableText(
                text = AnnotatedString("See All"),
                onClick = {},
                style = TextStyle(
                    color = Color(0xFF0E94FF),
                    fontWeight = FontWeight.Bold
                )
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
//        contentPadding = PaddingValues(
//            start = 15.dp,
//            top = 16.dp,
//            end = 15.dp,
//            bottom = 16.dp
//        ),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.SpaceBetween,

            ) {
            items(specialityList.size) { item ->
                BoxSpeciality(icon = specialityList.get(item), text = specialityDesc.get(item))
            }
        }
    }
}


@Composable
fun BoxSpeciality(icon: Int?, text: String? = null) {
    Box(
        modifier = Modifier
            .padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xFFD5EDFF).copy(alpha = 0.3f))
                    .size(60.dp, 60.dp),
                contentAlignment = Alignment.Center,
                content = {
                    icon?.let { painterResource(id = it) }?.let {
                        Image(
                            painter = it,
                            contentDescription = "",
                            modifier = Modifier
                                .size(width = 32.dp, height = 32.dp)
                        )
                    }
                }
            )
            if (text != null) {
                Text(
                    text = text,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}
