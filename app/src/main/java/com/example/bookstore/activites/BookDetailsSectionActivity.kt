package com.example.bookstore.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.bookstore.databinding.DetailsItemBookBinding
import com.example.bookstore.models.Book

class BookDetailsSectionActivity : AppCompatActivity() {
    private lateinit var binding: DetailsItemBookBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DetailsItemBookBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentData()
    }


    private fun getIntentData() {
        val bundle: Bundle? = intent.extras
        val data: Book? = bundle?.get("BOOK") as? Book

        setData(data)
    }

    private fun setData(data: Book?) {
        data?.let {
            binding.tvTitle.text = it.title
            binding.tvSubTitle.text = it.description
            Glide.with(this)
                .load(it.coverImage)
                .into(binding.imgBook)
        }
    }
}