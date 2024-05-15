package com.example.bookstore.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.bookstore.models.Book
import com.example.bookstore.repository.BooksRepository


class BookViewModel : ViewModel() {

    private val repository = BooksRepository()

    fun getBooks(callback: (List<Book>) -> Unit) {
        repository.getBookFromApi { books ->
            callback(books)
        }
        Log.d("TAG", "getBooks vmn" + toString())

    }
}
