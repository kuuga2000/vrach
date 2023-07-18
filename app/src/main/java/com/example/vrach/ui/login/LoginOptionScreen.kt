package com.example.vrach.ui.login

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vrach.R
import com.example.vrach.ui.theme.PurpleGrey80
import com.example.vrach.ui.theme.PurpleWhite

@Composable
fun LoginOptionScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(250.dp)
                    .width(250.dp),
                painter = painterResource(id = R.drawable.login_option),
                contentDescription = ""
            )
            Text(
                text = "Let's you in",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LoginButtons(text = "Continue With Facebook", iconButton = R.drawable.facebook_icon)
            Spacer(modifier = Modifier.height(10.dp))
            LoginButtons(text = "Continue With Google", iconButton = R.drawable.google_icon2)
        }
    }
}

@Composable
fun LoginButtons(
    text: String = "",
    @DrawableRes iconButton: Int
) {
    Button(
        modifier = Modifier.fillMaxWidth()
            .height(60.dp),
        border = BorderStroke(1.dp, Color(0xFFF1F2F3)),
        shape = RoundedCornerShape(30),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = Color.Black
        ),
        onClick = { /*TODO*/ }) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = iconButton),
                contentDescription = "",
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VrachPreview() {
    LoginOptionScreen()
}