package com.watermelon.superhero.model.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Work(
    @SerializedName("base")
    val base: String?,
    @SerializedName("occupation")
    val occupation: String?
) : Parcelable