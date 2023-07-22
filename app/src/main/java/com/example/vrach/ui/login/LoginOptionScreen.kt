package com.example.vrach.ui.login

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vrach.R
import com.example.vrach.ui.util.clickableWithoutRipple

@Composable
fun LoginOptionScreen(
    onSignUpClicked: () -> Unit = {}
) {
    val scrollState = rememberScrollState()
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxSize()
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
            LoginButtons(text = "Continue with Facebook", iconButton = R.drawable.facebook_icon)
            Spacer(modifier = Modifier.height(10.dp))
            LoginButtons(text = "Continue with Google", iconButton = R.drawable.google_icon2)
            Spacer(modifier = Modifier.height(20.dp))
            LineOptions()
            Spacer(modifier = Modifier.height(20.dp))
            LoginButtons(
                text = "Sign in with password",
                backgroundColor = Color(0xFFF246BFD),
                textColor = Color.White
            )
            Spacer(modifier = Modifier.height(25.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.clickableWithoutRipple(
                    interactionSource = interactionSource,
                    onClick = onSignUpClicked
                )
            ) {
                Text(
                    text = "Don't have an account?",
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = "Sign up",
                    color = Color(0xFFF246BFD)
                )
            }
        }
    }
}

@Composable
fun LineOptions(text: String = "or", f: Float = 0.2f) {
    Row(Modifier.fillMaxWidth(0.9f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Box(modifier = Modifier
            .height(1.dp)
            .weight(1f)
            .background(Color(0xFFF1F2F3))) {}
        Text(
            text = AnnotatedString(text), modifier = Modifier.weight(f),
            style = TextStyle(
                textAlign = TextAlign.Center
            ),
        )
        Box(modifier = Modifier
            .height(1.dp)
            .weight(1f)
            .background(Color(0xFFF1F2F3))) {}
    }
}
@Composable
fun LoginButtons(
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

@Preview(showBackground = true)
@Composable
fun VrachPreview() {
 //   LoginOptionScreen(navController = (Int) -> Unit)
}