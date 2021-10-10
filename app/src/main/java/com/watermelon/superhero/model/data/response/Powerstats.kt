package com.watermelon.superhero.model.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Powerstats(
    @SerializedName("combat")
    val combat: String?,
    @SerializedName("durability")
    val durability: String?,
    @SerializedName("intelligence")
    val intelligence: String?,
    @SerializedName("power")
    val power: String?,
    @SerializedName("speed")
    val speed: String?,
    @SerializedName("strength")
    val strength: String?
) : Parcelable