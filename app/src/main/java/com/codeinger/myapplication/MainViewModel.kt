package com.codeinger.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    fun run(){
        viewModelScope.launch {
            while (true){
                Log.i("fkvhjfdv", "onCreate: ")
                delay(2000)
            }
        }
    }

}