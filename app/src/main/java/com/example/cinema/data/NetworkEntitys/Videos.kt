package com.example.cinema.data.NetworkEntitys

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Videos (
    @SerializedName("trailers" ) var trailers : ArrayList<Trailers> = arrayListOf()
):Parcelable
