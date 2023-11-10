package com.example.cinema.data.NetworkEntitys

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Countries (

    @SerializedName("name" ) var name : String? = null

): Serializable
