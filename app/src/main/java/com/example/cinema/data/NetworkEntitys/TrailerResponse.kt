package com.example.cinema.data.NetworkEntitys

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TrailerResponse(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("persons") var persons: ArrayList<Persons> = arrayListOf(),
    @SerializedName("videos") var videos: Videos? = Videos(),
) : Parcelable

