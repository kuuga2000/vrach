package com.example.vrach

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.vrach.route.Routes
import com.example.vrach.ui.home.HomeScreen
import com.example.vrach.ui.login.LoginOptionScreen
import com.example.vrach.ui.register.RegisterScreen
import com.example.vrach.ui.util.VrachAppBar

@Composable
fun VrachApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Routes.valueOf(
        backStackEntry?.destination?.route ?: Routes.Login.name
    )

    Scaffold(
        topBar = {
            if (currentScreen.segment == "Login") {
                VrachAppBar(
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() },
                    currentScreen = currentScreen
                )
            }
        },
        containerColor = Color.White,
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.Login.name,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            composable(Routes.Login.name) {
                LoginOptionScreen(
                    onSiginClicked = {
                        navController.navigate(Routes.Home.name)
                    },
                    onSignUpClicked = {
                        navController.navigate(Routes.Signup.name)
                    }
                )
            }
            composable(Routes.Signup.name) {
                RegisterScreen(
                    onSignInClicked = {
                        navController.navigate(Routes.Login.name)
                    }
                )
            }
            composable(Routes.Home.name) {
                Log.d("Pretty Printed JSONxx:", innerPadding.toString())
                HomeScreen(
                    modifier = Modifier,
                    onAvatarClicked = {
                        navController.navigate(Routes.Signup.name)
                    }
                )
            }
        }
    }
}



@Composable
fun Test() {
    Text("Sdf");
}
