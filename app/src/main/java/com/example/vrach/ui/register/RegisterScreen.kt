package com.example.vrach.ui.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vrach.R
import com.example.vrach.ui.login.LineOptions
import com.example.vrach.ui.login.LoginButtons

@Composable
fun RegisterScreen() {
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
                painter = painterResource(id = R.drawable.register_logo2),
                contentDescription = ""
            )
            Text(
                text = "Create New Account",
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
            Spacer(modifier = Modifier.height(20.dp))
            LineOptions()
            Spacer(modifier = Modifier.height(20.dp))
            LoginButtons(
                text = "Sign in with password",
                backgroundColor = Color(0xFFF246BFD),
                textColor = Color.White
            )
        }
    }
}