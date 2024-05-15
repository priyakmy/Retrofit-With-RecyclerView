package com.example.bookstore.retrofit

import com.example.bookstore.models.Book
import com.example.bookstore.models.BooksResponse
import com.example.bookstore.models.Student
import retrofit2.Call
import retrofit2.http.GET

interface BookApi {


    @GET("/api/v1/books")
    fun getRandomBookList(): Call<List<Book>>

    @GET("/api/v1/students")
    fun getStudentList(): Call<List<Student>>

}