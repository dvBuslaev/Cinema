package com.example.cinema.data.NetworkEntitys

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExternalId(

    @SerializedName("kpHD") var kpHD: String? = null

) : Parcelable
