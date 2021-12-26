package com.example.flickrbrowserappretrofit.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flickrbrowserappretrofit.API.APIClient
import com.example.flickrbrowserappretrofit.API.APIInterface
import com.example.flickrbrowserappretrofit.Adapter.RecyclerViewAdapter
import com.example.flickrbrowserappretrofit.Model.Photo
import com.example.flickrbrowserappretrofit.Model.PhotoX
import com.example.flickrbrowserappretrofit.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var etSearch:EditText
    private lateinit var searchButton: FloatingActionButton

    var apiInterface = APIClient().getClient()?.create(APIInterface::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerView)
        etSearch = findViewById(R.id.etSearch)
        searchButton = findViewById(R.id.searchButton)
        searchButton.setOnClickListener {
            getData(etSearch.text.toString())
        }
    }
    fun getData(s:String){
        apiInterface!!.getPhotos(s)?.enqueue(object :Callback<PhotoX?>{
            override fun onResponse(call: Call<PhotoX?>, response: Response<PhotoX?>) {
               updateRV(response.body()!!.photos.photo)
            }

            override fun onFailure(call: Call<PhotoX?>, t: Throwable) {
                println(t.message)
            }
        })
    }
    private fun updateRV(imageList: List<Photo>){
        recyclerView.adapter = RecyclerViewAdapter(imageList)
        recyclerView.layoutManager = GridLayoutManager(this,3)
    }
}