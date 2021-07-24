package com.codeinger.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.btn);
        btn.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                doSomeTaskWithCoroutine()
            }
        }

    }

    private suspend fun doSomeTaskWithCoroutine() {
        delay(3000)
        withContext(Dispatchers.Main){
            Toast.makeText(this@MainActivity,"Task done.",Toast.LENGTH_SHORT).show()
        }
    }
}