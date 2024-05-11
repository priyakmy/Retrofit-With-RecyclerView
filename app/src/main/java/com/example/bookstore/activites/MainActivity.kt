package com.example.bookstore.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bookstore.databinding.ActivityMainBinding
import com.example.bookstore.pojo.BookList
import com.example.bookstore.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val bookLiveData = MutableLiveData<BookList>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView( binding)
        getData()
    }

    private fun getData() {
        RetrofitInstance.bookApi.getRandomBookList().enqueue(object : Callback<BookList?> {
            override fun onResponse(call: Call<BookList?>, response: Response<BookList?>) {
                response.body()?.let { bookList ->
                    bookLiveData.postValue(bookList)
                }
            }

            override fun onFailure(call: Call<BookList?>, t: Throwable) {
                Log.e("Test", "Error fetching book: ${t.message}")
            }

        })
    }

    fun observeBookLiveData(): LiveData<BookList> = bookLiveData

}