package com.example.bookstore.activites

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import com.example.bookstore.Adapters.BookAdapter
import com.example.bookstore.databinding.ActivityMainBinding
import com.example.bookstore.models.Book
import com.example.bookstore.viewModels.BookViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButtonClickListener()
        getBooks()
    }

    private fun getBooks() {
        viewModel.getBooks { books ->
            setData(books)
        }
    }

    private fun setData(books: List<Book>) {
        val adapter = BookAdapter(books) { clickedBook ->
            val intent = Intent(this, BookDetailsSectionActivity::class.java)
            val bundle = bundleOf("BOOK" to clickedBook)
            intent.putExtras(bundle)
            startActivity(intent)
        }
        binding.rvBooks.adapter = adapter
    }

    private fun setupButtonClickListener() {
        binding.btnStudent.setOnClickListener {
            val intent = Intent(this, StudentActivity::class.java)
            startActivity(intent)
        }
    }
}
