package com.example.remind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.remind.homepage.HomepageScreen
import com.example.remind.screen.onboard.LoginScreen
import com.example.remind.screen.onboard.OnBoardScreen
import com.example.remind.screen.onboard.RegisterScreen


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var navController = rememberNavController()
            NavHost(navController = navController, startDestination = "onboard"){
                composable(route = "onboard"){
                    OnBoardScreen(navController)
                }
                composable(route = "register"){
                    RegisterScreen(navController)

                }
                composable(route = "login"){
                    LoginScreen(navController)
                }
                composable(route = "homepage"){
                    HomepageScreen(navController)
                }
            }

        }
    }
}
