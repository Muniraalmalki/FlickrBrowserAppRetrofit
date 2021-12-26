package com.example.flickrbrowserappretrofit.Model

data class Photo(
    var farm: Int = 0,
    var id: String = "",
    var isfamily: Int = 0,
    var isfriend: Int = 0,
    var ispublic: Int = 0,
    var originalformat: String = "",
    var originalsecret: String = "",
    var owner: String = "",
    var secret: String = "",
    var server: String = "",
    var title: String = ""
)