package com.example.bookstore.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookstore.models.Book
import com.example.bookstore.repository.BooksRepository


class BookViewModel : ViewModel() {

    private val _books: MutableLiveData<List<Book>> = MutableLiveData()
    val books: LiveData<List<Book>> = _books



    fun getBooks() {
        val repo = BooksRepository()
        repo.getBookFromApi() {
            _books.value = it
        }
        Log.d("TAG", "getBooks vmn" + toString())

    }
}
