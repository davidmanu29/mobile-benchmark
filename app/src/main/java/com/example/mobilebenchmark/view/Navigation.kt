package com.example.mobilebenchmark.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mobilebenchmark.controller.Controller
import com.example.mobilebenchmark.db.BenchmarkDao
import com.example.mobilebenchmark.db.BenchmarkDb


@Composable
fun Navigation(navHostController : NavHostController, controller: Controller, dao: BenchmarkDao){

    NavHost(navController = navHostController, startDestination = ScreenRoutes.MainScreen.route){

        composable(ScreenRoutes.MainScreen.route){
            MainScreen(navController = navHostController)
        }
        composable(ScreenRoutes.TestScreen.route){
            TestScreen(controller)
        }
        composable(ScreenRoutes.Scoreboard.route){
            ScoreBoard(navController = navHostController, dao)
        }
    }
}
