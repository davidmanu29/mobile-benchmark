package com.example.mobilebenchmark.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ScoreTable(
    val cpuScore : Long,
    val memScore : Long,
    val gpuScore : Long,
    val totalScore : Long,
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)
