package com.example.cinema.data.NetworkEntitys

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ExternalId (

    @SerializedName("kpHD" ) var kpHD : String? = null

): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(kpHD)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExternalId> {
        override fun createFromParcel(parcel: Parcel): ExternalId {
            return ExternalId(parcel)
        }

        override fun newArray(size: Int): Array<ExternalId?> {
            return arrayOfNulls(size)
        }
    }
}
