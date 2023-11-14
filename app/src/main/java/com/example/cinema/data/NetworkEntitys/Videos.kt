package com.example.cinema.data.NetworkEntitys

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Videos (

    @SerializedName("trailers" ) var trailers : ArrayList<Trailers> = arrayListOf()

):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.createTypedArrayList(Trailers)?: arrayListOf()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(trailers)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Videos> {
        override fun createFromParcel(parcel: Parcel): Videos {
            return Videos(parcel)
        }

        override fun newArray(size: Int): Array<Videos?> {
            return arrayOfNulls(size)
        }
    }
}