package com.example.mobilebenchmark.view

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.graphics.drawable.toBitmap
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.mobilebenchmark.R
import com.example.mobilebenchmark.controller.Controller
import com.example.mobilebenchmark.db.BenchmarkDao
import com.example.mobilebenchmark.db.ScoreTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.system.measureTimeMillis

@Composable
fun TestScreen(controller : Controller) {

    var scoreCPU by remember {
        mutableStateOf(0L)
    }

    var scoreMEM by remember {
        mutableStateOf(0L)
    }
    var scoreGPU by remember {
        mutableStateOf(0L)
    }

    var started by remember {
        mutableStateOf(false)
    }

    var totalScore by remember{
        mutableStateOf(false)
    }

    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background1),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        if (started){
            CircularProgressIndicator(modifier = Modifier.size(100.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
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
            Button(
                onClick = {
                    scope.launch {

                        started = true
                        val cpuResult = async{
                            controller.getCpuResult()
                        }
                        val memResult = async{
                            controller.getMemoryResult()
                        }
                        scoreCPU = cpuResult.await()
                        scoreMEM = memResult.await()
                        //scoreGPU = score
                    }
                }
            ) {
                Text(text = "START")
            }

            //Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Total score is: ${(scoreCPU + scoreGPU + scoreMEM)/3}",
                fontSize = 25.sp,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xffD5D2D2)
                )
            )
            Text(
                text = "CPU Score is: $scoreCPU",
                fontSize = 25.sp,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xffD5D2D2)
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Memory Score is: $scoreMEM",
                fontSize = 25.sp,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xffD5D2D2)
                )
            )

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "GPU Score is: $scoreGPU",
                fontSize = 25.sp,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xffD5D2D2)
                )
            )

            Spacer(modifier = Modifier.height(50.dp))
            if (started){
                BoxWithConstraints (modifier = Modifier.fillMaxSize()){
                    var totalTime = 0L
                    Canvas(modifier = Modifier.matchParentSize()){
                         totalTime = measureTimeMillis {
                            for (j in 0 until 30000) {
                                drawCircle(
                                    color = Color.Yellow,
                                    radius = 50f,
                                    center = Offset(j.toFloat(), 1f)
                                )
                            }
                            for (j in 0 until 30000) {
                                drawRect(
                                    color = Color.Blue,
                                    size = Size(50f, 100f)
                                )
                            }
                        }
                    }
                    LaunchedEffect(key1 = true){
                        scoreGPU = totalTime
                    }
                }
            }
        }
    }
}