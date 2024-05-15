package com.example.bookstore.repository

import android.util.Log
import com.example.bookstore.Adapters.BookAdapter
import com.example.bookstore.models.Book
import com.example.bookstore.models.BooksResponse
import com.example.bookstore.retrofit.RetrofitInstance
import com.example.bookstore.utils.JsonDataHolder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksRepository {

fun getBooks() = JsonDataHolder.booksResponse


    fun getBookFromApi(){
        RetrofitInstance.bookApi.getRandomBookList().enqueue(object : Callback<List<Book>>{
            override fun onResponse(call: Call<List<Book>>, response: Response<List<Book>>) {
                val data = response.body()!!

                Log.d("TAG" ,data.toString())
            }

            override fun onFailure(call: Call<List<Book>>, t: Throwable) {

                Log.d("TAG" , "OnFaliure:" + t.message)

            }


        })

    }
}
