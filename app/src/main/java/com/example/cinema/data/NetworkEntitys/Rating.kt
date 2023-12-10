package com.example.cinema.data.NetworkEntitys

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rating (
    @SerializedName("kp"                 ) var kp                 : Double? = null,
    @SerializedName("imdb"               ) var imdb               : Double? = null,
): Parcelable
