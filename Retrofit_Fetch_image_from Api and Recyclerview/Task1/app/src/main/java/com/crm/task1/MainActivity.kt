package com.crm.task1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com/"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = Color.rgb(237,229,229 )

        var rev = findViewById<RecyclerView>(R.id.rev)
        rev.layoutManager = GridLayoutManager(MainActivity@this,2)

        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        var result = retrofit.getallPhotos()
        result.enqueue(object : Callback<List<PhotosDataItem>?> {
            override fun onResponse(
                call: Call<List<PhotosDataItem>?>,
                response: Response<List<PhotosDataItem>?>
            ) {
                var photosDataItem:ArrayList<PhotosDataItem> = ArrayList()
                photosDataItem = (response.body() as ArrayList<PhotosDataItem>?)!!

                var photoadapter = PhotoAdapter(applicationContext,photosDataItem)
                rev.adapter = photoadapter

            }

            override fun onFailure(call: Call<List<PhotosDataItem>?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}