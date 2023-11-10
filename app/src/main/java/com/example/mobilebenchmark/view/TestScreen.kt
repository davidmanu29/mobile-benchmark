package com.example.mobilebenchmark.view

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobilebenchmark.R
import com.example.mobilebenchmark.controller.Controller
import com.example.mobilebenchmark.db.BenchmarkDao
import com.example.mobilebenchmark.db.ScoreTable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@Composable
fun TestScreen( controller : Controller) {

    var score by remember {
        mutableStateOf(0L)
    }

    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background1),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Mobile Device Testing",
                fontSize = 70.sp,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xffD5D2D2)
                )
            )
            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = score.toString(),
                fontSize = 25.sp,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xffD5D2D2)
                )
            )
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {
                    scope.launch {
//                        Log.d("SCORE", "BtnClicked")
//                        val time1 = System.currentTimeMillis()
//                        Log.d("SCORE", "Time before: $time1")
//                        controller.floatingPoint()
//                        val time2 = System.currentTimeMillis()
//                        Log.d("SCORE", "Time after: $time2")
//                        score = time2 - time1
//                        Log.d("SCORE", score.toString())
                        score = controller.getCpuResult()
                    }
                }
            ) {
                Text(text = "START")
            }
        }
    }
}
