package com.example.vrach.ui.register

import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vrach.R
import com.example.vrach.ui.login.LineOptions
import com.example.vrach.ui.login.SocialLoginButtons
import com.example.vrach.ui.login.SocialRegisterButton
import com.example.vrach.ui.theme.PurpleWhite
import com.example.vrach.ui.util.clickableWithoutRipple

@Composable

fun StepOneRegisterForm(
    onSignInClicked: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailColor by remember { mutableStateOf(Color(0xFFF6F6F6)) }
    var passwordColor by remember { mutableStateOf(Color(0xFFF6F6F6)) }
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth(0.9f)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it},
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.email_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFF246BFD),
                unfocusedBorderColor = PurpleWhite,
                focusedLabelColor = Color(0xFFF246BFD),
                cursorColor = Color(0xFFF246BFD),
                containerColor = emailColor
            ),
            singleLine = true,
            shape = RoundedCornerShape(30),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent {
                    emailColor = if (it.isFocused) Color(0xFFFFB8CBF1) else Color(0xFFF6F6F6)
                }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it},
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.password_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .width(20.dp)
                        .height(20.dp)
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFFF246BFD),
                unfocusedBorderColor = PurpleWhite,
                focusedLabelColor = Color(0xFFF246BFD),
                cursorColor = Color(0xFFF246BFD),
                containerColor = passwordColor,
            ),
            singleLine = true,
            shape = RoundedCornerShape(30),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent {
                    passwordColor = if (it.isFocused) Color(0xFFFFB8CBF1) else Color(0xFFF6F6F6)
                }
        )
        Spacer(modifier = Modifier.height(30.dp))
        SocialLoginButtons(
            text = "Sign up",
            backgroundColor = Color(0xFFF246BFD),
            textColor = Color.White
        )
        Spacer(modifier = Modifier.height(30.dp))
        LineOptions(text = "or continue with", f = 1f)
        Spacer(modifier = Modifier.height(30.dp))
        SocialRegisterButton()
        Spacer(modifier = Modifier.height(35.dp))
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.clickableWithoutRipple(
                interactionSource = interactionSource,
                onClick = onSignInClicked
            )
        ) {
            Text(
                text = "Already have an account?",
                color = Color.Gray
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = "Sign in",
                color = Color(0xFFF246BFD)
            )
        }
    }
}

@Preview
@Composable
fun StepOneRegisterFormPreview() {
    StepOneRegisterForm();
}