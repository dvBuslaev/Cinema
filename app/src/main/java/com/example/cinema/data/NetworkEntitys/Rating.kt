package com.example.cinema.data.NetworkEntitys

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Ratingg (

    @SerializedName("kp"                 ) var kp                 : Double? = null,
    @SerializedName("imdb"               ) var imdb               : Double? = null,


): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(kp)
        parcel.writeValue(imdb)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Ratingg> {
        override fun createFromParcel(parcel: Parcel): Ratingg {
            return Ratingg(parcel)
        }

        override fun newArray(size: Int): Array<Ratingg?> {
            return arrayOfNulls(size)
        }
    }
}
