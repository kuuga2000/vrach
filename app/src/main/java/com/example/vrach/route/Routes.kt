package com.example.vrach.route

/**
 * enum values that represent the screens in the app
 */
enum class Routes(val title: String, val segment: String) {
    Start(
        title = "Vrach",
        segment = "Login"
    ),
    Login(
        title = "Login",
        segment = "Login"
    ),
    Signup(
        title = "Register",
        segment = "Login"
    ),
    BioData(
        title = "Fill Your Profile",
        segment = "Login"
    ),
    ForgotPassword(
        title = "Forgot Password",
        segment= "Login"
    ),
    Home(
        title = "Home",
        segment = "Home"
    ),
    DoctorSpeciality(
        title = "Doctors",
        segment = "Home"
    )
}