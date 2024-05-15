package com.example.bookstore.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.bookstore.Adapters.BookAdapter
import com.example.bookstore.databinding.ActivityMainBinding
import com.example.bookstore.models.Book
import com.example.bookstore.viewModels.BookViewModel


class MainActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BookViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getBooks()
    }

    private fun getBooks()
    {
        viewModel.getBooks { books ->
            setData(books)
        }
    }

    private fun setData(books: List<Book>)
    {
        val adapter = BookAdapter(books)
        binding.rvBooks.adapter = adapter
    }
}