package com.example.bookstore.retrofit

import com.example.bookstore.models.Student
import retrofit2.Call
import retrofit2.http.GET

interface StudentApi {

    @GET("v1/students")
    fun getStudentList(): Call<List<Student>>
}