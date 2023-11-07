package com.example.cinema.data.ApiService

import com.example.cinema.data.NetworkEntitys.Movie
import com.example.cinema.data.NetworkEntitys.MovieList
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("movie?token=8E4WPC4-GVZMCDN-P7C6ZSA-YACNXC1&field=rating.kp&sfield=rating.kp&search=7-10&sortField=votes.kpsortType=-1&limit=10&type=movie")
    fun getMovieList(@Query("page") page:Int): Single<MovieList>





}