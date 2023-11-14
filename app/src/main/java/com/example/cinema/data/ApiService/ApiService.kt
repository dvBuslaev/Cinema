package com.example.cinema.data.ApiService

import com.example.cinema.data.NetworkEntitys.MovieResponse
import com.example.cinema.data.NetworkEntitys.TrailerResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
   /* &notNullFields=poster.url*/

    @GET("movie?token=8E4WPC4-GVZMCDN-P7C6ZSA-YACNXC1&&limit=5&type=movie&year=2020-2023&rating.kp=8.3-10")
    fun getMovieList(@Query("page") page: Int): Single<MovieResponse>

    @GET("movie/{idFilms}?token=YG6VWAJ-M18M254-P5KF2A4-5VQGA9N")
    fun getMovieTrailer(@Query("idFilms") idFilm : String): Single<TrailerResponse>


}