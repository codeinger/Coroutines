package com.codeinger.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runBlocking {
            test1()
        }

    }

    suspend fun test(){
        val job = lifecycleScope.launch {
            delay(2000)
            Log.i("fdkjcjkdfn", "2 sec finish: ")
        }

        job.join()
        Log.i("fdkjcjkdfn", "test: ")
    }

    suspend fun test1(){
        val deferred : Deferred<Int> = lifecycleScope.async {
            delay(2000)
            Log.i("fdkjcjkdfn", "2 sec finish: ")
            10
        }
        val value = deferred.await()
        Log.i("fdkjcjkdfn", "test: "+value)
    }


}