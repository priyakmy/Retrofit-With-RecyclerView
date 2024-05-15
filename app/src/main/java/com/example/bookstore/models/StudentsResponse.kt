package com.example.bookstore.models


data class StudentsResponse (
    val student : List<Student>
)

data class Student(
    val courses: List<String>,
    val image: String,
    val name: String

)