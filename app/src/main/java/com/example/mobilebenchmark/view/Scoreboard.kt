package com.example.mobilebenchmark.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.mobilebenchmark.R
import com.example.mobilebenchmark.db.BenchmarkDao

@Composable
fun ScoreBoard(navController: NavController, dao: BenchmarkDao) {

    val tableList by dao.selectScores().collectAsState(initial = emptyList())

    LazyColumn {
        items(tableList) {
            // TODO create a composable function that takes care of a line for an entry + check for initial null in db
            // TODO also put it in Box
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background1),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Scoreboard",
                fontSize = 70.sp,
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    color = Color(0xffD5D2D2)
                )
            )
        }
    }
}