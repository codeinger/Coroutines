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

class MainActivity : AppCompatActivity() {

    val TAG = "MyRanDomTag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.text)

        lifecycleScope.launch(Dispatchers.IO) {
            val result =  networkCall()
            withContext(Dispatchers.Main){text.text = result}
        }

    }

    private suspend fun networkCall() : String{
        Log.i(TAG, "networkCall: start")
        delay(3000)
        Log.i(TAG, "networkCall: end")
        return "Result"
    }


}