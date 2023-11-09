package com.example.mobilebenchmark

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import com.example.mobilebenchmark.view.Navigation
import androidx.navigation.compose.rememberNavController
import com.example.mobilebenchmark.controller.Controller

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                val navController = rememberNavController()
                val controller = Controller()
                Navigation(navController, controller)
        }
    }
}