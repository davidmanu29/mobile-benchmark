package com.example.mobilebenchmark.View

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navHostController : NavHostController){

    NavHost(navController = navHostController, startDestination = ScreenRoutes.MainScreen.route){

        composable(ScreenRoutes.MainScreen.route){
            MainScreen(navController = navHostController)
        }
        composable(ScreenRoutes.TestScreen.route){
            TestScreen(navController = navHostController)
        }
        composable(ScreenRoutes.Scoreboard.route){
            ScoreBoard(navController = navHostController)
        }
    }
}