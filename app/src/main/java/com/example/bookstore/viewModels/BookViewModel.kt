package com.example.bookstore.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookstore.models.Book
import com.example.bookstore.repository.BooksRepository
import com.example.bookstore.retrofit.RetrofitInstance


class BookViewModel : ViewModel() {

    private val _books = MutableLiveData() <List<Book>>()
    val books: LiveData<List<Book>> = _books



    fun getBooks() {
        val repo = BooksRepository()
        val res = repo.getBookFromApi()
        Log.d("TAG", "getBooks vmn" + toString())
       // _books.value = res
        _books.value = RetrofitInstance.bookApi.getRandomBookList()

    }
}
