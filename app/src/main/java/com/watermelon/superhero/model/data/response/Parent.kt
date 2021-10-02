package com.watermelon.superhero.model.data.response


import com.google.gson.annotations.SerializedName

data class Parent(
    @SerializedName("response")
    val response: String?,
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("results-for")
    val resultsFor: String?
)