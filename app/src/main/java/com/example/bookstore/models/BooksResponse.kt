package com.example.bookstore.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class BooksResponse(
    @SerializedName("books")
    val books: List<Book>
)

@Parcelize
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
):Parcelable