package com.codeinger.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    val TAG = "MyRanDomTag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {

            val time = measureTimeMillis {

                val job = launch {
                    val s1 = async { networkCall1() }
                    val s2 = async { networkCall2() }
                    val s3 = async { networkCall3() }
                    Log.i(TAG, "onCreate: ${s1.await()}  ${s2.await()} ${s3.await()}")
                }

                job.join()

                Log.i(TAG, "network call done: ")
            }

            Log.i(TAG, "onCreate: time $time")

        }


    }

    suspend fun networkCall1():String{
        delay(1000)
        Log.i(TAG, "networkCall1: called")
        return "result 1"
    }

    suspend fun networkCall2():String{
        delay(3000)
        Log.i(TAG, "networkCall2: called")
        return "result 2"
    }

    suspend fun networkCall3():String{
        delay(2000)
        Log.i(TAG, "networkCall3: called")
        return "result 3"
    }


}