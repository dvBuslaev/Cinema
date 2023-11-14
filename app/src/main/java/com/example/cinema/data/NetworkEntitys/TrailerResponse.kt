package com.example.cinema.data.NetworkEntitys

import android.media.Rating
import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class TrailerResponse (

    @SerializedName("id"                  ) var id                  : Int?                          = null,
    @SerializedName("persons"             ) var persons             : ArrayList<Persons>            = arrayListOf(),
    @SerializedName("videos"              ) var videos              : Videos?                       = Videos(),


    ):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.createTypedArrayList(Persons)?: arrayListOf(),
        parcel.readValue(Videos::class.java.classLoader) as Videos?,
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeParcelable(videos, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TrailerResponse> {
        override fun createFromParcel(parcel: Parcel): TrailerResponse {
            return TrailerResponse(parcel)
        }

        override fun newArray(size: Int): Array<TrailerResponse?> {
            return arrayOfNulls(size)
        }
    }
}
