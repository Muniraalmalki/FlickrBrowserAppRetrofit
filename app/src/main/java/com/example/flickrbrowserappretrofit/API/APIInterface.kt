package com.example.flickrbrowserappretrofit.API

import com.example.flickrbrowserappretrofit.Model.PhotoX
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("services/rest/?method=flickr.photos.search&api_key=fd0dd06c334d35cd7323bb8ac77ed626&sort=relevance&parse_tags=1&content_type=7&extras=original_format&format=json&nojsoncallback=1")
    fun getPhotos(@Query("text") searchWord:String): Call<PhotoX?>?
}