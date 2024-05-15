package com.example.bookstore.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookstore.models.Book
import com.example.bookstore.models.BooksResponse
import com.example.bookstore.repository.BooksRepository


class BookViewModel : ViewModel() {

    private val _books:MutableLiveData<BooksResponse> = MutableLiveData() <List<Book>()
    val books = _books



    fun getBooks() {
        val repo = BooksRepository()
        val res = repo.getBookFromApi()
        Log.d("TAG", "getBooks vmn" + toString())
       // _books.value = res

    }
}
