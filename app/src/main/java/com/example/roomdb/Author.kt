package com.example.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "author_table")
data class Author(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)


