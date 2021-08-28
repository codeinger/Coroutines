package com.codeinger.myapplication.data.room.dao

import androidx.room.*
import com.codeinger.myapplication.model.Post
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Insert
    suspend fun insert(post : Post)

    @Update
    suspend fun update(post : Post)

    @Delete
    suspend fun delete(post : Post)

    @Query("SELECT * FROM Post")
    fun loadAllPost() : Flow<List<Post>>

    @Insert
    suspend fun insertAllPost(vararg posts : Post)

}