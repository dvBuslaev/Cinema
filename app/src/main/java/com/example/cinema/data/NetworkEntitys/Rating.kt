package com.example.cinema.data.NetworkEntitys

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Ratingg (

    @SerializedName("kp"                 ) var kp                 : Double? = null,
    @SerializedName("imdb"               ) var imdb               : Double? = null,


): Serializable
