package com.example.cinema.data.NetworkEntitys

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Ratingg (

    @SerializedName("kp"                 ) var kp                 : Double? = null,
    @SerializedName("imdb"               ) var imdb               : Double? = null,


): Parcelable
