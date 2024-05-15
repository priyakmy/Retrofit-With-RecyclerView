package com.example.bookstore.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.bookstore.models.Book
import com.example.bookstore.models.Student
import com.example.bookstore.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//Used to arrange the data comes from Api

class StudentsRepository {

        fun getStudentFromApi(callBack:(List<Student>) -> Unit) {
        RetrofitInstance.studentApi.getStudentList().enqueue(object : Callback<List<Student>>
                                                             {
            override fun onResponse(call: Call<List<Student>> , response: Response<List<Student>>) {
                val data = response.body()!!
                callBack.invoke(data)

                Log.d("TAG" , data.toString())
            }

            override fun onFailure(call: Call<List<Student>>, t: Throwable) {

                Log.d("TAG" , "OnFailure:" + t.message)

            }


        })

    }
}