package com.example.vrach.ui.login

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vrach.R

@Composable
fun SocialLoginButtons(
    text: String = "",
    @DrawableRes iconButton: Int = 0,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent,
    textColor: Color = Color.Black,
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp),
        border = BorderStroke(1.dp, Color(0xFFF1F2F3)),
        shape = RoundedCornerShape(30),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = textColor
        ),
        onClick = { /*TODO*/ }) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxWidth()
        ) {
            if(iconButton != 0) {
                Image(
                    painter = painterResource(id = iconButton),
                    contentDescription = "",
                    modifier = modifier
                        .width(20.dp)
                        .height(20.dp)
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
            Text(text = text)
        }
    }
}

@Composable
fun SocialRegisterButton(
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor
            ),
            border = BorderStroke(1.dp, Color(0xFFF1F2F3)),
            shape = RoundedCornerShape(25),
            modifier = Modifier.height(50.dp).width(65.dp),
            contentPadding = PaddingValues(13.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.facebook_icon),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor
            ),
            border = BorderStroke(1.dp, Color(0xFFF1F2F3)),
            shape = RoundedCornerShape(25),
            modifier = Modifier.height(50.dp).width(65.dp),
            contentPadding = PaddingValues(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.google_icon),
                contentDescription = "",
                contentScale = ContentScale.Fit
            )
        }
    }
}
