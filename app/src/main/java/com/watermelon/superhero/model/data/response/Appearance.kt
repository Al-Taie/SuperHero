package com.watermelon.superhero.model.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Appearance(
    @SerializedName("eye-color")
    val eyeColor: String?,
    @SerializedName("gender")
    val gender: String?,
    @SerializedName("hair-color")
    val hairColor: String?,
    @SerializedName("height")
    val height: List<String>?,
    @SerializedName("race")
    val race: String?,
    @SerializedName("weight")
    val weight: List<String>?
) : Parcelable