package com.example.cinema.data.NetworkEntitys

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/*@SerializedName("names"            ) var names            : ArrayList<Names>     = arrayListOf(),




@SerializedName("genres"           ) var genres           : ArrayList<Genres>    = arrayListOf(),
@SerializedName("countries"        ) var countries        : ArrayList<Countries> = arrayListOf(),
@SerializedName("externalId"       ) var externalId       : ExternalId?          = ExternalId(),*/
@Entity(tableName = "favoriteMovies")
@Parcelize
data class Movie(
    @SerializedName("name") var name: String? = null,

    @PrimaryKey
    @SerializedName("id") var id: Int? = null,

    @SerializedName("alternativeName") var alternativeName: String? = null,
    @SerializedName("enName") var enName: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("year") var year: Int? = null,
    @Embedded
    @SerializedName("poster") var poster: Poster? = Poster(),
    @Embedded
    @SerializedName("rating") var rating: Rating? = Rating(),
    @Embedded
    @SerializedName("votes") var votes: Votes? = Votes(),
    @SerializedName("description") var description: String? = null,
    @SerializedName("shortDescription") var shortDescription: String? = null,


    ) : Parcelable