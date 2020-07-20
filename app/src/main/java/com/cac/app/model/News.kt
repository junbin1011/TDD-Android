package com.cac.app.model

import com.google.gson.annotations.SerializedName

class News(
    val title: String,
    val date: String,
    @SerializedName("thumbnail_pic_s")
    val thumbnail1: String,
    @SerializedName("thumbnail_pic_s02")
    val thumbnail2: String,
    @SerializedName("thumbnail_pic_s03")
    val thumbnail3: String
)