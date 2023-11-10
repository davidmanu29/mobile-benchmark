package com.example.mobilebenchmark.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface BenchmarkDao {

    @Upsert
    suspend fun upsertScore (scoreTable : ScoreTable)

    @Query("SELECT * FROM scoreTable ORDER BY totalScore ASC LIMIT 10")
    fun selectScores(): Flow<List<ScoreTable>>
}