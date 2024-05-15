package com.example.bookstore.viewModels

import androidx.lifecycle.ViewModel
import com.example.bookstore.models.Student
import com.example.bookstore.repository.StudentsRepository

class StudentViewModel : ViewModel()
{

    private val repository = StudentsRepository()

    fun getStudents(callback: (List<Student>) -> Unit) {
        repository.getStudentFromApi { student ->
            callback(student)
        }
    }

}

