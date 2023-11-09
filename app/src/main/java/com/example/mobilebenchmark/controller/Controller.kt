package com.example.mobilebenchmark.controller

import com.example.mobilebenchmark.model.TestModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.math.pow
import kotlin.random.Random
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

//TODO Implement it.
class Controller {

    fun start () : TestModel ?{

        //val cpuScore : Float = floatingPoint().toFloat()
        val memoryScore : Float = 0.0f
        val gpuScore : Float = 0.0f

        //val testModel = TestModel(cpuScore, memoryScore, gpuScore)
        //println("this is the score ${testModel.cpuScore}")
        //return testModel
        return null
    }
    private fun encrypt (stringToEncrypt : String, secretKey : String) : String? {

        var encryptionString = "I am the string that will be encrypted happily and without any issues whatsoever."
        var secretKey = "iRK6K7AzmFz1TP91pUHxQViE8y8RyIT22LfbR6jxx20nJk4A3MCJQKLeUOyXYEMY"

        return null
    }

    private fun generateRandomFloat() : Float {

        return Random.nextInt(1,10000000) + Random.nextFloat()
    }

    suspend fun floatingPoint() : Long{

        return withContext(Dispatchers.IO){
            val listOfArrays = mutableListOf<FloatArray>()
            for (i in 1 .. 100){
                val arrayOfFloats = FloatArray(500000)
                for (j in arrayOfFloats.indices){
                    arrayOfFloats[j] = generateRandomFloat()
                }
                listOfArrays.add(arrayOfFloats)
            }
            val timeStart = System.currentTimeMillis()
            listOfArrays.forEach{
                for (j in 1 until it.size step 2){
                    val mulResult : Float = it[j - 1] * it[j]
                    val divResult : Float = it[j - 1] / it[j]
                }
            }
            val timeEnd = System.currentTimeMillis()
            val timeFloatingPoint = timeEnd - timeStart
            timeFloatingPoint
        }
    }
}

