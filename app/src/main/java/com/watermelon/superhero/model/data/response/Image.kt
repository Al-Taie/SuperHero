package com.watermelon.superhero.model.data.response


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("url")
    val url: String?
)