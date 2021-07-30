package com.codeinger.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("fdhjvef", "onCreate : ${Thread.currentThread().name}")

        GlobalScope.launch {
            Log.i("fdhjvef", "coroutine launch in : ${Thread.currentThread().name}")
            delay(3000)
            Log.i("fdhjvef", "delay complete : ${Thread.currentThread().name}")
        }

    }
}