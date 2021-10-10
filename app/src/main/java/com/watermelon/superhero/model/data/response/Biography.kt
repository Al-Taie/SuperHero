package com.watermelon.superhero.model.data.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Biography(
    @SerializedName("aliases")
    val aliases: List<String>?,
    @SerializedName("alignment")
    val alignment: String?,
    @SerializedName("alter-egos")
    val alterEgos: String?,
    @SerializedName("first-appearance")
    val firstAppearance: String?,
    @SerializedName("full-name")
    val fullName: String?,
    @SerializedName("place-of-birth")
    val placeOfBirth: String?,
    @SerializedName("publisher")
    val publisher: String?
): Parcelable