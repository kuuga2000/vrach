package com.example.vrach

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vrach.ui.login.LoginOptionScreen
import com.example.vrach.ui.register.RegisterScreen

/**
 * enum values that represent the screens in the app
 */
enum class VrachScreen(val title: String) {
    Start(title = "Vrach"),
    Login(title = "Login"),
    Signup(title = "Signup"),
    ForgotPassword(title = "Forgot Password")
}


@Composable
fun VrachApp(
    navController: NavHostController = rememberNavController()
) {
    //LoginOptionScreen()
    NavHost(
        navController = navController,
        startDestination = VrachScreen.Login.name
    ) {
        composable(VrachScreen.Login.name) {
            LoginOptionScreen(
                onSignUpClicked = {
                    navController.navigate(VrachScreen.Signup.name)
                }
            )
        }
        composable(VrachScreen.Signup.name) {
            RegisterScreen()
        }
    }
}
