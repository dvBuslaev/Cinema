package com.example.cinema.data.NetworkEntitys

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Votes (
    @SerializedName("kp"                 ) var kinop                 : Int? = null,
    @SerializedName("imdb"               ) var imdbvote               : Int? = null,
    @SerializedName("filmCritics"        ) var filmCritics        : Int? = null,
    @SerializedName("russianFilmCritics" ) var russianFilmCritics : Int? = null,
    @SerializedName("await"              ) var await              : Int? = null

): Parcelable