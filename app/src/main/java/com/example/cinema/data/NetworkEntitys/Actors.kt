package com.example.cinema.data.NetworkEntitys

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Persons(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("photo") var photo: String? = null,
    @SerializedName("name") var name: String? = null,
) : Parcelable
