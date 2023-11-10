package com.example.cinema.data.NetworkEntitys

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ExternalId (

    @SerializedName("kpHD" ) var kpHD : String? = null

): Serializable
