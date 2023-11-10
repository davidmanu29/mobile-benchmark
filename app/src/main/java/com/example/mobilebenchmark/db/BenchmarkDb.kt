package com.example.mobilebenchmark.db

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [
        ScoreTable::class
    ],
    version = 1
)
 abstract class BenchmarkDb : RoomDatabase() {

    abstract val scoreDao : BenchmarkDao
}