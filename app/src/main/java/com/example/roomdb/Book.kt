package com.example.roomdb

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "book_table",
    foreignKeys = [
        ForeignKey(
            entity = Author::class,
            parentColumns = ["id"],
            childColumns = ["authorId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Publisher::class,
            parentColumns = ["id"],
            childColumns = ["publisherId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val authorId: Int,
    val publisherId: Int
)
