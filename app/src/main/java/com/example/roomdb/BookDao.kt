package com.example.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookDao {
    @Insert
    suspend fun insert(book: Book)

    @Query("SELECT * FROM book_table")
    suspend fun getAllBooks(): List<Book>
}

