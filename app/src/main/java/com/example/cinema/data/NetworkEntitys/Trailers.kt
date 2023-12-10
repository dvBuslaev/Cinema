package com.example.cinema.data.NetworkEntitys

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Trailers (

    @SerializedName("url"  ) var url  : String? = null,
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("site" ) var site : String? = null,
    @SerializedName("type" ) var type : String? = null

):Parcelable
