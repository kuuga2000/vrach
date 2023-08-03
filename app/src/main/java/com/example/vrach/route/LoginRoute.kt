package com.example.vrach.route

/**
 * enum values that represent the screens in the app
 */
enum class LoginRoute(val title: String) {
    Start(title = "Vrach"),
    Login(title = "Login"),
    Signup(title = "Signup"),
    BioData(title = "Fill Your Profile"),
    ForgotPassword(title = "Forgot Password")
}