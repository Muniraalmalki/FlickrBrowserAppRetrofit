package com.example.flickrbrowserappretrofit.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.flickrbrowserappretrofit.R

class FullSreenImage : AppCompatActivity() {
    private lateinit var image: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_sreen_image)
        image = findViewById(R.id.image)


        val imgeURL = intent.extras?.getString("data")
        Glide.with(this).load(imgeURL).into(image)


        image.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

}