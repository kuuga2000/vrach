package com.example.vrach.ui.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vrach.R
import com.example.vrach.model.LoginDataState

@Composable
fun RegisterScreen(
    onSignInClicked: () -> Unit = {}
) {
    var registerStep by remember{ mutableStateOf(1) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxSize()
    ) {
        if(registerStep == 1) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth(1f)
                ) {
                Image(
                    modifier = Modifier
                        .height(120.dp)
                        .width(110.dp),
                    painter = painterResource(id = R.drawable.register_logo2),
                    contentDescription = ""
                )
                Spacer(modifier = Modifier.height(35.dp))
            }
        }

        RegisterDataScreen(
            onSignInClicked = onSignInClicked,
            onSignUpClicked= { registerStep++ },
            stepRegister = registerStep
        )
    }
}

@Composable
fun RegisterDataScreen(
    onSignInClicked: () -> Unit = {},
    onSignUpClicked: () -> Unit,
    stepRegister: Int = 1
) {
    val viewModel: LoginViewModel = viewModel()
    val uiLoginState by viewModel.uiLoginState.collectAsState()
    if(stepRegister == 1) {
        StepOneRegisterForm(
            onSignInClicked = onSignInClicked,
            onSignUpClicked = onSignUpClicked
        )
    }
    if(stepRegister == 2) {
        StepBioRegisterForm(
            uiLoginState = uiLoginState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        )
    }
}

@Preview
@Composable
fun RegisterScreenView() {
    RegisterScreen()
}