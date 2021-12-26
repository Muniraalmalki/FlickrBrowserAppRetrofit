package com.example.flickrbrowserappretrofit.Model

data class Photos(
    var page: Int = 0,
    var pages: Int = 0,
    var perpage: Int = 0,
    var photo: List<Photo> = listOf(),
    var total: Int = 0
)