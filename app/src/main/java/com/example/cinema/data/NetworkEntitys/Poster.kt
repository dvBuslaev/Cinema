package com.example.cinema.data.NetworkEntitys

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Poster (

    @SerializedName("url"        ) var url        : String? = null

): Serializable
