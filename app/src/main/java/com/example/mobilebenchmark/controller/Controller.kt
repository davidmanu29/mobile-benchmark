package com.example.mobilebenchmark.controller

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.PixelFormat
import android.hardware.HardwareBuffer
import android.media.ImageReader
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import com.example.mobilebenchmark.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.math.pow
import kotlin.random.Random


//TODO Implement it.
class Controller(private val context : Context) {

    /*@SuppressLint("GetInstance")
    private fun encrypt(stringToEncrypt: String, secretKey : String): String? {
        Security.addProvider(BouncyCastleProvider())
        val keyBytes : ByteArray
        return try {
            keyBytes = secretKey.toByteArray(charset("UTF8"))
            val skey = SecretKeySpec(keyBytes, "AES")
            val input = stringToEncrypt.toByteArray(charset("UTF8"))

            val cipher = Cipher.getInstance("AES/ECB/PKCS7Padding")
            cipher.init(Cipher.ENCRYPT_MODE, skey)
            val cipherText = ByteArray(cipher.getOutputSize(input.size))
            var ctLength = cipher.update(
                input, 0, input.size,
                cipherText, 0
            )
            ctLength += cipher.doFinal(cipherText,ctLength)
            String(Base64.encode(cipherText))
        }
         catch (uee: UnsupportedEncodingException) {
            uee.printStackTrace()
             "uee"
        } catch (ibse: IllegalBlockSizeException) {
            ibse.printStackTrace()
            "ibse"
        } catch (bpe: BadPaddingException) {
            bpe.printStackTrace()
            "bpe"
        } catch (ike: InvalidKeyException) {
            ike.printStackTrace()
            "ike"
        } catch (nspe: NoSuchPaddingException) {
            nspe.printStackTrace()
            "nspe"
        } catch (nsae: NoSuchAlgorithmException) {
            nsae.printStackTrace()
            "nsae"
        } catch (e: ShortBufferException) {
            e.printStackTrace()
            "shortBuffer"
        }
    }*/
    suspend fun getResults(){
        getCpuResult()
        getMemoryResult()
    }

    suspend fun encrypt() {
        return withContext(Dispatchers.IO){
            val stringToEncrypt = " TfiUszbd5nKt59SpQ2uYK24YQkkocQuQ\n" +
                    "1frPuEnOKqT9lzHoAyOAqaxIK9yHgmPA\n" +
                    "fvAGjnK395gVo51mvm3l6hiuDhSi0F1j\n" +
                    "xdn1kjk6XXXV3H7rw6Ys4cSY0ixCNnbO\n" +
                    "EXociP3tT29WY2xKc929k65WbCtyQuFl\n" +
                    "CBQUI64nUHF3XVQzc1eCgI8qcpeD8UFf\n" +
                    "LooPWyXWBeNtXaStO2W5SRLNTVwWcSXd\n" +
                    "KWNTInuLsAxhEdvu3Voh0fACa6OwOiGW\n" +
                    "zlYIWAoYnEwaBY2nFnnGACta0lJjkhR4\n" +
                    "bqd6EJOW1vUeBOC5JsyTpnknal4SxYMV\n" +
                    "z2Bb5e3X0ljy4moeL5lUPhcGFSwzIofG\n" +
                    "zlN8uxvK4e6TtQ5vBZYN2mj5pJtBisnC\n" +
                    "9rsD4sCS8Eezv8LwlHIWnLHAGtCpjPLn\n" +
                    "aElxJXkdoYj6YZMJPgtZP7nGXsqMnwHU\n" +
                    "slEE3a36ztF9rGEI219FZzqwgeJAIzex\n" +
                    "E2Zi4HCbVrNgnsvkOh954f0RdDqBZW8O\n" +
                    "TBcZIywLWaRcGtSbI1kASpSWsyYhOZf8\n" +
                    "2M9tW772wSFN1C8QcaVyD0l4DpIDJAmM\n" +
                    "fE5oO4ryDFDk3h8n528s9mq2dVI9INGN\n" +
                    "Gpknygvj1szEt5Ij3eefxBRzVd1c84gn\n" +
                    "VjgeDK1bexXwZ68tAXfVxgZp3lmZ4lkW\n" +
                    "g87fFOZyJcgk492X2HdpGRoi44hUeLiH\n" +
                    "G5gZ08b133lHMIoqNYdjy9BltjmH2SgA\n" +
                    "8oX8p9J30ONPwRphAT18RUK1ThMkL61w"
            for (i in 1 until 5000){
                val charList = mutableListOf<Char>()
                stringToEncrypt.forEach {
                    val randomCipherCode = Random.nextInt(2.0.pow(5).toInt())
                    charList.add((it.code * randomCipherCode).toChar())
                }
                val resultingString = charList.joinToString(separator = "")
            }
        }
    }

    private fun generateRandomFloat(): Float {
        return Random.nextInt(1, 10000000) + Random.nextFloat()
    }
    suspend fun floatingPoint(): Long {
        return withContext(Dispatchers.IO) {
            val listOfArrays = mutableListOf<FloatArray>()
            for (i in 1..100) {
                val arrayOfFloats = FloatArray(40000)
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
        var totalTime = 0L
        for (i in 1 .. 5){
            val time1 = System.currentTimeMillis()
            floatingPoint()
            encrypt()
            val time2 = System.currentTimeMillis()
            totalTime += time2 - time1
        }

        return totalTime/5
    }
    suspend fun memoryTest(arrayT11 : Array<Int>, arrayT12 : Array<Int>,
                           arrayT21 : Array<Int>, arrayT22 : Array<Int>,
                           arrayT31 : Array<Int>, arrayT32 : Array<Int>,) : Long {
        return withContext(Dispatchers.IO){
            for (i in 1 until 500000){
                val aux = arrayT11[i]
                arrayT11[i] = arrayT12[i]
                arrayT12[i] = aux
            }
            for (i in 1 until 2000000){
                val aux = arrayT21[i]
                arrayT21[i] = arrayT22[i]
                arrayT22[i] = aux
            }
            for (i in 1 until 3000000){
                val aux = arrayT31[i]
                arrayT31[i] = arrayT32[i]
                arrayT32[i] = aux
            }
            1
        }
    }

    private fun fillRandomArray(array: Array<Int>){
        for (i in array.indices){
            array[i] = Random.nextInt()
        }
    }

    suspend fun getMemoryResult() : Long {
        var totalTime = 0L
        val arrayT11 = Array(500000){ 0 }
        val arrayT12 = Array(500000){ 0 }
        val arrayT21 = Array(2000000) { 0 }
        val arrayT22 = Array(2000000) { 0 }
        val arrayT31 = Array(3000000) { 0 }
        val arrayT32 = Array(3000000) { 0 }
        fillRandomArray(arrayT11)
        fillRandomArray(arrayT12)
        fillRandomArray(arrayT21)
        fillRandomArray(arrayT22)
        fillRandomArray(arrayT31)
        fillRandomArray(arrayT32)
        for (i in 1 .. 5){
            val time1 = System.currentTimeMillis()
            memoryTest(arrayT11, arrayT12, arrayT21, arrayT22, arrayT31, arrayT32)
            val time2 = System.currentTimeMillis()
            totalTime += time2 - time1
        }
        return totalTime/5
    }
}


