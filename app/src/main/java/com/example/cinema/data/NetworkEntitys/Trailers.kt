package com.example.cinema.data.NetworkEntitys

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Trailers (

    @SerializedName("url"  ) var url  : String? = null,
    @SerializedName("name" ) var name : String? = null,
    @SerializedName("site" ) var site : String? = null,
    @SerializedName("type" ) var type : String? = null

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeString(name)
        parcel.writeString(site)
        parcel.writeString(type)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Trailers> {
        override fun createFromParcel(parcel: Parcel): Trailers {
            return Trailers(parcel)
        }

        override fun newArray(size: Int): Array<Trailers?> {
            return arrayOfNulls(size)
        }
    }
}