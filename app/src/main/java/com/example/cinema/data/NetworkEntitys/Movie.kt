package com.example.cinema.data.NetworkEntitys

import com.google.gson.annotations.SerializedName

data class Movie (

    @SerializedName("name"             ) var name             : String?              = null,
    @SerializedName("id"               ) var id               : Int?                 = null,
    @SerializedName("externalId"       ) var externalId       : ExternalId?          = ExternalId(),

    @SerializedName("alternativeName"  ) var alternativeName  : String?              = null,
    @SerializedName("enName"           ) var enName           : String?              = null,
    @SerializedName("names"            ) var names            : ArrayList<Names>     = arrayListOf(),

    @SerializedName("type"             ) var type             : String?              = null,
    @SerializedName("year"             ) var year             : Int?                 = null,
    @SerializedName("description"      ) var description      : String?              = null,

    @SerializedName("shortDescription" ) var shortDescription : String?              = null,
    @SerializedName("rating"           ) var rating           : Ratingg?             = Ratingg(),
    @SerializedName("votes"            ) var votes            : Votes?               = Votes(),

    @SerializedName("poster"           ) var poster           : Poster?              = Poster(),
    @SerializedName("genres"           ) var genres           : ArrayList<Genres>    = arrayListOf(),
    @SerializedName("countries"        ) var countries        : ArrayList<Countries> = arrayListOf(),

    @SerializedName("releaseYears"     ) var releaseYears     : ArrayList<String>    = arrayListOf()

)