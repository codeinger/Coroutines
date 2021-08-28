package com.codeinger.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Post(
    @PrimaryKey(autoGenerate = true)
    val id  : Int,
    val title : String,
    val description : String
)
