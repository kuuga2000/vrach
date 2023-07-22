package com.example.vrach

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vrach.route.LoginRoute
import com.example.vrach.ui.login.LoginOptionScreen
import com.example.vrach.ui.register.RegisterScreen
import com.example.vrach.ui.util.VrachAppBar

@Composable
fun VrachApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = LoginRoute.valueOf(
        backStackEntry?.destination?.route ?: LoginRoute.Login.name
    )

    Scaffold(
        topBar = {
            VrachAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = {
                    navController.navigateUp()
                },
                currentScreen = currentScreen
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = LoginRoute.Login.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(LoginRoute.Login.name) {
                LoginOptionScreen(
                    onSignUpClicked = {
                        navController.navigate(LoginRoute.Signup.name)
                    }
                )
            }
            composable(LoginRoute.Signup.name) {
                RegisterScreen()
            }
        }
    }
}
