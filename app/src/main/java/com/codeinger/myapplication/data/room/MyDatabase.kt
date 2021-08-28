package com.codeinger.myapplication.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codeinger.myapplication.data.room.dao.PostDao
import com.codeinger.myapplication.model.Post


@Database(entities = [Post::class], version = 1)
abstract class MyDatabase : RoomDatabase() {

    abstract fun postDao() : PostDao

    companion object {
        private var instance: MyDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): MyDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, MyDatabase::class.java,"my_db").build()
            return instance!!
        }
    }
}