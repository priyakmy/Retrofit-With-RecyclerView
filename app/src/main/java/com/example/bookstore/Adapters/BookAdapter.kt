package com.example.bookstore.Adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookstore.Model.BookViewModel
import com.example.bookstore.R

class BookAdapter(private val mList: List<BookViewModel>) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.bookcardviewlayout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val BookViewModel = mList[position]

        holder.imageView.setImageResource(BookViewModel.image)
        holder.textView.text = BookViewModel.text

    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(BookView: View) : RecyclerView.ViewHolder(BookView) {
        val imageView: ImageView = itemView.findViewById(R.id.imgBook)
        val textView: TextView = itemView.findViewById(R.id.tvBookName)
    }
}
