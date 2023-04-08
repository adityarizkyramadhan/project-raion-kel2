package com.example.remind

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.remind.homepage.HomepageScreen
import com.example.remind.screen.onboard.*
import com.example.remind.task.AddTaskScreen
import com.example.remind.task.TaskScreen


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var navController = rememberNavController()
            NavHost(navController = navController, startDestination = "onboard") {
                composable(route = "onboard") {
                    OnBoardScreen(navController)
                }
                composable(route = "register") {
                    RegisterScreen(navController)
                }
                composable(route = "login") {
                    LoginScreen(navController)
                }
                composable(route = "homepage") {
                    HomepageScreen(navController)
                }
                composable(route = "task") {
                    TaskScreen(navController)
                }
                composable(route = "addtask") {
                    AddTaskScreen(navController)
                }
                composable(route = "profile"){
                    ProfileScreen(navController)
                }
                composable(route = "updateprofile"){
                    UpdateProfileScreen(navController)
                }
                composable(route = "updatepassword"){
                    UpdatePasswordScreen(navController)
                }
            }
        }
    }
}