package com.example.cinema.data.NetworkEntitys

import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("docs") var movie: List<Movie>,
    @SerializedName("total") var total: Int? = null,
    @SerializedName("limit") var limit: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("pages") var pages: Int? = null

)
