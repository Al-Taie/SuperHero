package com.watermelon.superhero.model.data.response


import com.google.gson.annotations.SerializedName

data class Work(
    @SerializedName("base")
    val base: String?,
    @SerializedName("occupation")
    val occupation: String?
)