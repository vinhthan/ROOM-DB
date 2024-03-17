package com.example.roomdb

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var bookDao: BookDao
    private lateinit var authorDao: AuthorDao
    private lateinit var publisherDao: PublisherDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Khởi tạo database
        val database = AppDatabase.getDatabase(applicationContext)
        bookDao = database.bookDao()
        authorDao = database.authorDao()
        publisherDao = database.publisherDao()

        // Thêm author và book vào database bằng Coroutine

        lifecycleScope.launch {

            val author = Author(name = "John Doe")

            val authorId = authorDao.insert(author)


            val book = Book(title = "Sample Book", authorId = authorId.toInt(), publisherId = authorId.toInt())
            bookDao.insert(book)
        }

        // Lấy danh sách books từ database bằng Coroutine
        lifecycleScope.launch {
            val books = bookDao.getAllBooks()
            for (book in books) {
                println("Book: ${book.title}, Author ID: ${book.authorId}, Publisher ID: ${book.publisherId}")
            }
        }

        // Lấy danh sách authors từ database bằng Coroutine
        lifecycleScope.launch {
            val authors = authorDao.getAllAuthors()
            for (author in authors) {
                println("Author: ${author.name}")
            }
        }

        // Lấy danh sách publishers từ database bằng Coroutine
        lifecycleScope.launch {
            val publishers = publisherDao.getAllPublishers()
            for (publisher in publishers) {
                println("Publisher: ${publisher.name}")
            }
        }
    }
}

