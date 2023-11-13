package com.example.cinema.data.NetworkEntitys

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/*@SerializedName("names"            ) var names            : ArrayList<Names>     = arrayListOf(),

@SerializedName("votes"            ) var votes            : Votes?               = Votes(),


@SerializedName("genres"           ) var genres           : ArrayList<Genres>    = arrayListOf(),
@SerializedName("countries"        ) var countries        : ArrayList<Countries> = arrayListOf(),
@SerializedName("externalId"       ) var externalId       : ExternalId?          = ExternalId(),*/
data class Movie(
    @SerializedName("name") var name: String? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("alternativeName") var alternativeName: String? = null,
    @SerializedName("enName") var enName: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("year") var year: Int? = null,
    @SerializedName("poster") var poster: Poster? = Poster(),
    @SerializedName("rating") var rating: Ratingg? = Ratingg(),
    @SerializedName("description") var description: String? = null,
    @SerializedName("shortDescription") var shortDescription: String? = null,
    @SerializedName("releaseYears") var releaseYears: ArrayList<String> = arrayListOf()

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Poster::class.java.classLoader) as Poster?,
        parcel.readValue(Ratingg::class.java.classLoader) as Ratingg?,
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList() ?: arrayListOf()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(id)
        parcel.writeString(alternativeName)
        parcel.writeString(enName)
        parcel.writeString(type)
        parcel.writeValue(year)
        parcel.writeValue(poster)
        parcel.writeValue(rating)
        parcel.writeString(description)
        parcel.writeString(shortDescription)
        parcel.writeStringList(releaseYears)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}