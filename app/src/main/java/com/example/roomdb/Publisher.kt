package com.example.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "publisher_table")
data class Publisher(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)
