package com.example.bookstore.Adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookstore.databinding.ItemBooksBinding
import com.example.bookstore.models.Book

class BookAdapter(private var mList: List<Book>) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {


    fun setBookList(mList: List<Book>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemBooksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = mList[position]
        holder.setData(book)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class BookViewHolder(private val binding: ItemBooksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(data: Book) {
            binding.tvTitle.text = data.title
            binding.tvSubTitle.text = data.description
            data.coverImage?.let { setImage(it) }

        }

        private fun setImage(img: String) {
            Glide.with(binding.root.context).load(img).into(binding.ivImg)
        }
    }
}