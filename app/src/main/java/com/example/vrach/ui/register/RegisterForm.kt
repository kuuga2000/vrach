package com.example.vrach.ui.register

import android.widget.Toast
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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vrach.R
import com.example.vrach.model.customer.Customer
import com.example.vrach.model.LoginDataState
import com.example.vrach.ui.login.LineOptions
import com.example.vrach.ui.login.SocialLoginButtons
import com.example.vrach.ui.login.SocialRegisterButton
import com.example.vrach.ui.theme.PurpleWhite
import com.example.vrach.ui.util.clickableWithoutRipple
import com.example.vrach.utils.Utils

@Composable

fun StepOneRegisterForm(
    onSignInClicked: () -> Unit = {},
    onSignUpClicked: () -> Unit = {}
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var emailColor by remember { mutableStateOf(Color(0xFFF6F6F6)) }
    var passwordColor by remember { mutableStateOf(Color(0xFFF6F6F6)) }
    val interactionSource = remember { MutableInteractionSource() }
    val contextCurrent = LocalContext.current
    var usernameError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }

    val viewModel: LoginViewModel = viewModel()

    viewModel.setLoginData(
        LoginDataState(
            username = username,
            password = password
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier.fillMaxWidth(0.9f)
    ) {
        OutlinedTextField(
            isError = usernameError.isNotEmpty(),
            value = username,
            onValueChange = { username = it},
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.person_icon),
                    contentDescription = "",
                    modifier = Modifier
                        .width(35.dp)
                        .height(35.dp)
                )
            },
            placeholder = {
                Text("Username")
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
        Text(
            text = usernameError,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            isError = passwordError.isNotEmpty(),
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
            placeholder = {
                Text("Password")
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
        Text(
            text = passwordError,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(30.dp))
        SocialLoginButtons(
            text = "Sign up",
            backgroundColor = Color(0xFFF246BFD),
            textColor = Color.White,
            onClicked = {
                if (username.isBlank() || password.isBlank()) {
                    Toast.makeText(contextCurrent, "Need username and password",Toast.LENGTH_SHORT).show()
                    usernameError = if (username.isBlank()) {
                        "Username must be filled"
                    } else {
                        ""
                    }
                    passwordError = if (password.isBlank()) {
                        "Password must be filled"
                    } else {
                        ""
                    }
                } else {
                    onSignUpClicked()
                }
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        LineOptions(text = "or continue with", f = 1f, isRegister = true)
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

@Composable
fun StepBioRegisterForm(
    modifier: Modifier = Modifier,
    uiLoginState: LoginDataState,
){
    var fullname by remember { mutableStateOf("") }
    var nickname by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("0") }

    var fullNameColor by remember { mutableStateOf(Color(0xFFF6F6F6)) }
    var nicknameColor by remember { mutableStateOf(Color(0xFFF6F6F6)) }
    var dobColor by remember { mutableStateOf(Color(0xFFF6F6F6)) }
    var emailColor by remember { mutableStateOf(Color(0xFFF6F6F6)) }
    var genderColor by remember { mutableStateOf(Color(0xFFF6F6F6)) }
    val viewModel: LoginViewModel = viewModel();

    var customerRegisterData = Customer(
        firstname = Utils.firstname(fullname)?.let { it },
        lastname = Utils.lastname(fullname)?.let { it },
        nickname = nickname,
        dateOfBirth = dob,
        email = email,
        gender = gender.toInt(),
        username = uiLoginState?.username,
        password = uiLoginState?.password
    )

    Column(
    ) {
        Text(text = "Upload Avatar")
        uiLoginState.username?.let { Text(text = it) }
        uiLoginState.password?.let { Text(text = it) }
    }
    Row() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = fullname,
                onValueChange = {fullname = it},
                label = {
                    Text("Full Name")
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFF246BFD),
                    unfocusedBorderColor = PurpleWhite,
                    focusedLabelColor = Color(0xFFF246BFD),
                    cursorColor = Color(0xFFF246BFD),
                    containerColor = fullNameColor
                ),
                modifier = modifier
            )
            OutlinedTextField(
                value = nickname,
                onValueChange = {nickname = it},
                label = {
                    Text("Nickname")
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFF246BFD),
                    unfocusedBorderColor = PurpleWhite,
                    focusedLabelColor = Color(0xFFF246BFD),
                    cursorColor = Color(0xFFF246BFD),
                    containerColor = nicknameColor
                ),
                modifier = modifier
            )
            OutlinedTextField(
                value = dob,
                onValueChange = {dob = it},
                label = {
                    Text("Date of Birth")
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFF246BFD),
                    unfocusedBorderColor = PurpleWhite,
                    focusedLabelColor = Color(0xFFF246BFD),
                    cursorColor = Color(0xFFF246BFD),
                    containerColor = dobColor
                ),
                modifier = modifier
            )
            OutlinedTextField(
                value = email,
                onValueChange = {email = it},
                label = {
                    Text("Email")
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Next
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFF246BFD),
                    unfocusedBorderColor = PurpleWhite,
                    focusedLabelColor = Color(0xFFF246BFD),
                    cursorColor = Color(0xFFF246BFD),
                    containerColor = emailColor
                ),
                modifier = modifier
            )
            OutlinedTextField(
                value = gender,
                onValueChange = {gender = it},
                label = {
                    Text("Gender")
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Ascii,
                    imeAction = ImeAction.Done
                ),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xFFF246BFD),
                    unfocusedBorderColor = PurpleWhite,
                    focusedLabelColor = Color(0xFFF246BFD),
                    cursorColor = Color(0xFFF246BFD),
                    containerColor = genderColor
                ),
                modifier = modifier
            )
            Spacer(modifier = modifier.height(30.dp))
            SocialLoginButtons(
                text = "Continue",
                backgroundColor = Color(0xFFF246BFD),
                textColor = Color.White,
                modifier = modifier,
                onClicked = {
                    viewModel.crateAccount(customerRegisterData)
                }
            )
        }
    }
}

@Preview
@Composable
fun StepOneRegisterFormPreview() {
 //   StepOneRegisterForm();
}