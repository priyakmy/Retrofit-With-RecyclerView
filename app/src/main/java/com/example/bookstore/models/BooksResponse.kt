package com.example.bookstore.models

import com.google.gson.annotations.SerializedName
data class BooksResponse(
    @SerializedName("books")
    val books: List<Book>
)

data class Book(
    @SerializedName("author")
    val author: String? = "",
    @SerializedName("cover_image")
    val coverImage: String? = "",
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("genre")
    val genre: List<String>? = listOf(),
    @SerializedName("publication_year")
    val publicationYear: String? = "",
    @SerializedName("title")
    val title: String? = ""
)