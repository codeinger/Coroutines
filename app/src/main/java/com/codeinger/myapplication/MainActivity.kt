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

        GlobalScope.launch {
            Log.i("ekjfhcekjfn", "satrt: ")
            networkCall1()
            Log.i("ekjfhcekjfn", "end: ")
        }


    }

    suspend fun networkCall1(){
        delay(3000)
        Log.i("ekjfhcekjfn", "networkCall1: ")
        networkCall2()
    }

    fun networkCall2(){
        Log.i("ekjfhcekjfn", "networkCall2: ")
    }
}