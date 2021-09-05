package com.codeinger.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class MainActivity : AppCompatActivity() {

    private val TAG = "MyTag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn : Button = findViewById(R.id.button)

        val map = hashMapOf<String,Any>()
        map["name"] = "mayank"
        map["description"] = "description"

//        insertInRealTimeDataBase(map)
//
//        btn.setOnClickListener {
//            readFromRealTimeDatabase()
//        }


        lifecycleScope.launch {
            Firebase.firestore.collection("Post").document("new").set(map).await()
            Log.i(TAG, "data inserted.")
        }


        btn.setOnClickListener {
            lifecycleScope.launch {
                val await = Firebase.firestore.collection("Post").document("new").get().await()
                Log.i(TAG, "name: ${await.data?.get("name").toString()}" +
                        "description: ${await.data?.get("description").toString()}")
            }
        }

    }

    private fun readFromRealTimeDatabase() {
        lifecycleScope.launch {
            val await = Firebase.database.reference.child("Post").get().await()
            Log.i(TAG, "name: ${await.child("name").getValue(String::class.java)}" +
                    "description: ${await.child("description").getValue(String::class.java)}")
        }
    }

    private fun insertInRealTimeDataBase(map : HashMap<String, Any>) {
        lifecycleScope.launch {
            Firebase.database.reference.child("Post").setValue(map).await()
            Log.i(TAG, "Data inserted.")
        }
    }

}