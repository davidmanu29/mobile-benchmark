package com.example.mobilebenchmark.View

import androidx.navigation.NavController

sealed class ScreenRoutes(val route : String) {

    object MainScreen : ScreenRoutes("MainScreen")
    object TestScreen : ScreenRoutes("TestScreen")
    object Scoreboard : ScreenRoutes("Scoreboard")
}

object NavigationActions{
    fun navigateTo(navController: NavController, screen: ScreenRoutes){
        navController.navigate(screen.route)
    }
}