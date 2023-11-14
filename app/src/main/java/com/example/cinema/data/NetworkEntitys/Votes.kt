package com.example.cinema.data.NetworkEntitys

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Votes (

    @SerializedName("kp"                 ) var kp                 : Int? = null,
    @SerializedName("imdb"               ) var imdb               : Int? = null,
    @SerializedName("filmCritics"        ) var filmCritics        : Int? = null,
    @SerializedName("russianFilmCritics" ) var russianFilmCritics : Int? = null,
    @SerializedName("await"              ) var await              : Int? = null

): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(kp)
        parcel.writeValue(imdb)
        parcel.writeValue(filmCritics)
        parcel.writeValue(russianFilmCritics)
        parcel.writeValue(await)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Votes> {
        override fun createFromParcel(parcel: Parcel): Votes {
            return Votes(parcel)
        }

        override fun newArray(size: Int): Array<Votes?> {
            return arrayOfNulls(size)
        }
    }
}
