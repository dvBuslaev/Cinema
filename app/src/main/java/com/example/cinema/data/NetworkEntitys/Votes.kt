package com.example.cinema.data.NetworkEntitys

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Votes (

    @SerializedName("kp"                 ) var kp                 : Int? = null,
    @SerializedName("imdb"               ) var imdb               : Int? = null,
    @SerializedName("filmCritics"        ) var filmCritics        : Int? = null,
    @SerializedName("russianFilmCritics" ) var russianFilmCritics : Int? = null,
    @SerializedName("await"              ) var await              : Int? = null

): Serializable
