package com.example.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PublisherDao {
    @Insert
    suspend fun insert(publisher: Publisher)

    @Query("SELECT * FROM publisher_table")
    suspend fun getAllPublishers(): List<Publisher>
}
