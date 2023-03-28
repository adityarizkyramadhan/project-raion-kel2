package com.example.remind

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.remind.screen.onboard.OnBoardScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var navController = rememberNavController()
            NavHost(navController = navController, startDestination = "onboard"){
                composable(route = "onboard"){
                    OnBoardScreen(navController)
                }
                composable(route = "register"){

                }
            }

        }
    }
}
