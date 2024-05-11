package com.example.bookstore.pojo


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class BookListItem(
    @SerializedName("author")
    val author: String = "",
    @SerializedName("cover_image")
    val coverImage: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("genre")
    val genre: List<String> = listOf(),
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("publication_year")
    val publicationYear: Int = 0,
    @SerializedName("title")
    val title: String = ""
) : Parcelable