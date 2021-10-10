package com.watermelon.superhero.model.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Hero(
    @SerializedName("appearance")
    val appearance: @RawValue Appearance?,
    @SerializedName("biography")
    val biography: @RawValue Biography?,
    @SerializedName("connections")
    val connections: @RawValue Connections?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: @RawValue Image?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("powerstats")
    val powerstats: @RawValue Powerstats?,
    @SerializedName("work")
    val work: @RawValue Work?
) : Parcelable