package com.example.bookstore.activites

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bookstore.Adapters.BookAdapter
import com.example.bookstore.Adapters.StudentAdapter
import com.example.bookstore.R
import com.example.bookstore.databinding.ActivityMainBinding
import com.example.bookstore.models.Book
import com.example.bookstore.models.Student
import com.example.bookstore.viewModels.BookViewModel
import com.example.bookstore.viewModels.StudentViewModel

class StudentActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    private val viewModel: StudentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getStudents()

    }

    private fun getStudents()
    {
        viewModel.getStudents{ students ->
            setStudentsData(students)
        }
    }

    private fun setStudentsData(student: List<Student>)
    {
        val adapter = StudentAdapter(student)
        binding.rvBooks.adapter = adapter
    }
}