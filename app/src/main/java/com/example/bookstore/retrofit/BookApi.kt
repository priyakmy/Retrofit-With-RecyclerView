package com.example.bookstore.retrofit

import com.example.bookstore.pojo.BookList
import retrofit2.Call
import retrofit2.http.GET

interface BookApi {


    @GET("/api/v1/books")
    fun getRandomBookList(): Call<BookList>

}