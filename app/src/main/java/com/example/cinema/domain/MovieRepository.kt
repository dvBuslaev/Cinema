package com.example.cinema.domain

import com.example.cinema.data.NetworkEntitys.Movie
import com.example.cinema.data.NetworkEntitys.TrailerResponse

interface MovieRepository {
    fun getMovieList(page:Int):List<Movie>
    fun getMovieTrailer(idFilm:String):List<TrailerResponse>
}