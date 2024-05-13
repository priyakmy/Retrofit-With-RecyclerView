package com.example.bookstore.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.bookstore.Adapters.BookAdapter

import com.example.bookstore.databinding.ActivityMainBinding
import com.example.bookstore.models.BooksResponse
import com.example.bookstore.viewModels.BookViewModel


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BookViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getBooks()
        setupObserver()
    }

    private fun setupObserver() {
        viewModel.books.observe(this) {
            Log.d("TAG", "setupObserver: ${it.books}")
            setData(it)

        }
    }


    private fun getBooks() {
        viewModel.getBooks()
    }

    private fun setData(data:BooksResponse) {
        val adapter = BookAdapter(data.books)
        binding.rvBooks.adapter = adapter
    }

}