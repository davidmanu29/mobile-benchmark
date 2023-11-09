package com.example.mobilebenchmark.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobilebenchmark.controller.Controller
import com.example.mobilebenchmark.R
import kotlinx.coroutines.launch

@Composable
fun MainScreen(navController : NavController, controller : Controller) {

    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.background1)
            ,contentDescription = null
            ,modifier = Modifier.fillMaxSize()
            ,contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(50.dp))

            Text(text = "Mobile Benchmark",
                fontSize = 70.sp,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xffD5D2D2)
                )
            )

           Spacer(modifier = Modifier.height(200.dp))

            Button(onClick = {
                //NavigationActions.navigateTo(navController, ScreenRoutes.TestScreen)
                scope.launch {
                    println("Button clicked ")
                    val score = controller.floatingPoint()
                    println(score)
                }
            },
                Modifier.width(220.dp)) {

                Text(text = "Mobile tests",
                    fontSize = 25.sp)
            }

            Spacer(modifier = Modifier.height(30.dp))

            Button(onClick = { /*NavigationActions.navigateTo(navController, ScreenRoutes.Scoreboard)*/ }
                , Modifier.width(220.dp)) {

                Text(text = "Scoreboard",
                    fontSize = 25.sp)

            }
        }
    }
}
