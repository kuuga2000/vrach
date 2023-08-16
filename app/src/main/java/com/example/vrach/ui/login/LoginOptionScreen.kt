package com.example.vrach.ui.login

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
                    .height(210.dp)
                    .width(210.dp),
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
            SocialLoginButtons(text = "Continue with Facebook", iconButton = R.drawable.facebook_icon)
            Spacer(modifier = Modifier.height(10.dp))
            SocialLoginButtons(text = "Continue with Google", iconButton = R.drawable.google_icon2)
            Spacer(modifier = Modifier.height(20.dp))
            LineOptions()
            Spacer(modifier = Modifier.height(20.dp))
            SocialLoginButtons(
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
fun LineOptions(text: String = "or", f: Float = 0.2f, isRegister: Boolean = false) {
    Row(Modifier.fillMaxWidth(0.9f), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        var weightLine = 1f
        if (isRegister) {
            weightLine = 0.7f
        }
        Box(modifier = Modifier
            .height(1.dp)
            .weight(weightLine)
            .background(Color(0xFFF1F2F3))) {}
        Text(
            text = AnnotatedString(text), modifier = Modifier.weight(f),
            style = TextStyle(
                textAlign = TextAlign.Center
            ),
        )
        Box(modifier = Modifier
            .height(1.dp)
            .weight(weightLine)
            .background(Color(0xFFF1F2F3))) {}
    }
}

@Preview(showBackground = true)
@Composable
fun VrachPreview() {
 //   LoginOptionScreen(navController = (Int) -> Unit)
}