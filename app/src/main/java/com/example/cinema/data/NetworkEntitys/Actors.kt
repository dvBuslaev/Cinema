package com.example.cinema.data.NetworkEntitys

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Persons (

    @SerializedName("id"           ) var id           : Int?    = null,
    @SerializedName("photo"        ) var photo        : String? = null,
    @SerializedName("name"         ) var name         : String? = null,
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeString(photo)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Persons> {
        override fun createFromParcel(parcel: Parcel): Persons {
            return Persons(parcel)
        }

        override fun newArray(size: Int): Array<Persons?> {
            return arrayOfNulls(size)
        }
    }
}
