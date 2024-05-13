package com.example.bookstore.retrofit

import com.example.bookstore.models.BooksResponse
import retrofit2.Call
import retrofit2.http.GET

interface BookApi {


    @GET("/api/v1/books")
    fun getRandomBookList(): Call<BooksResponse>

}