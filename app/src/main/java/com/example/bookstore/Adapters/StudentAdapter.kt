package com.example.bookstore.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookstore.databinding.ItemStudentsBinding
import com.example.bookstore.models.Student

class StudentAdapter(private var mList: List<Student>) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = mList[position]
        holder.setData(student)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class StudentViewHolder(private val binding: ItemStudentsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setData(data: Student) {
            binding.tvName.text = data.name
            binding.tvCourse.text = data.courses.toString()
            data.image?.let { setImage(it) }
        }

        private fun setImage(img: String) {
            Glide.with(binding.root.context).load(img).into(binding.imgStudent)
        }
    }
}
