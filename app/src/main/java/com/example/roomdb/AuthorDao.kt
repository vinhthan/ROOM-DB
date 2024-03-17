package com.example.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AuthorDao {
    @Insert
    suspend fun insert(author: Author): Long

    @Query("SELECT * FROM author_table")
    suspend fun getAllAuthors(): List<Author>
}



