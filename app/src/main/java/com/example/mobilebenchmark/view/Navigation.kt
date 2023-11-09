package com.example.mobilebenchmark.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobilebenchmark.controller.Controller


@Composable
fun Navigation(navHostController : NavHostController, controller: Controller){

    NavHost(navController = navHostController, startDestination = ScreenRoutes.MainScreen.route){

        composable(ScreenRoutes.MainScreen.route){
            MainScreen(navController = navHostController, controller = controller)
        }
        composable(ScreenRoutes.TestScreen.route){
            TestScreen(navController = navHostController)
        }
        composable(ScreenRoutes.Scoreboard.route){
            ScoreBoard(navController = navHostController)
        }
    }
}