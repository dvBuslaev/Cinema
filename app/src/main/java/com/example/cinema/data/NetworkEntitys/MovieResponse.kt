package com.example.cinema.data.NetworkEntitys

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    @SerializedName("docs") var movies: List<Movie>,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("pages") var pages: Int? = null
) : Parcelable