package com.example.bookstore.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val         bookApi: BookApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://freetestapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BookApi::class.java)
    }

    val studentApi: StudentApi by lazy {
        Retrofit.Builder()
                .baseUrl("https://freetestapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(StudentApi::class.java)
    }

}