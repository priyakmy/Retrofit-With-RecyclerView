package com.example.bookstore.Adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookstore.databinding.ItemBooksBinding
import com.example.bookstore.models.Book

class BookAdapter(private var mList: List<Book>,val onClick:(Book)->Unit) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        Log.d("BookAdapter", "onCreateViewHolder")
        val binding = ItemBooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        Log.d("BookAdapter", "onBindViewHolder: position $position")
        val book = mList[position]
        holder.setData(book)
    }

    override fun getItemCount(): Int {
        Log.d("BookAdapter", "getItemCount: ${mList.size}")
        return mList.size
    }

    inner class BookViewHolder(private val binding: ItemBooksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(data: Book) {
            Log.d("BookAdapter", "setData: ${data.title}")
            binding.tvTitle.text = data.title
            binding.tvSubTitle.text = data.description
            data.coverImage?.let { setImage(it) }

            binding.cardView.setOnClickListener {
                onClick.invoke(data)
            }
        }

        private fun setImage(img: String) {
            Log.d("BookAdapter", "setImage: $img")
            Glide.with(binding.root.context).load(img).into(binding.ivImg)
        }
    }
}
