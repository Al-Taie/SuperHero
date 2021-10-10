package com.watermelon.superhero.model.data.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Connections(
    @SerializedName("group-affiliation")
    val groupAffiliation: String?,
    @SerializedName("relatives")
    val relatives: String?
): Parcelable