package com.example.mobilebenchmark.controller

import android.util.Log
import com.example.mobilebenchmark.model.TestModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.bouncycastle.jce.provider.BouncyCastleProvider
import java.security.Security
import kotlin.math.pow
import kotlin.random.Random
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime
import kotlin.time.measureTimedValue

//TODO Implement it.
class Controller {

    private fun encrypt(stringToEncrypt: String, secretKey: String): String? {
        //Security.addProvider(BouncyCastleProvider())
        var encryptionString =
            "I am the string that will be encrypted happily and without any issues whatsoever."
        var secretKey = "iRK6K7AzmFz1TP91pUHxQViE8y8RyIT22LfbR6jxx20nJk4A3MCJQKLeUOyXYEMY"



        return null
    }


    private fun generateRandomFloat(): Float {

        return Random.nextInt(1, 10000000) + Random.nextFloat()
    }
    suspend fun floatingPoint(): Long {
        return withContext(Dispatchers.IO) {
            val listOfArrays = mutableListOf<FloatArray>()
            for (i in 1..100) {
                val arrayOfFloats = FloatArray(100000)
                for (j in arrayOfFloats.indices) {
                    arrayOfFloats[j] = generateRandomFloat()
                }
                listOfArrays.add(arrayOfFloats)
            }
                listOfArrays.forEach {
                    for (j in 1 until it.size step 2) {
                        val mulResult: Float = it[j - 1] * it[j]
                        val divResult: Float = it[j - 1] / it[j]
                    }
                }
            1
        }
    }
    suspend fun getCpuResult(): Long {
        val time1 = System.currentTimeMillis()
        floatingPoint()
        val time2 = System.currentTimeMillis()
        return time2 - time1
    }
}


