package com.example.cinema.data.ApiService

import com.example.cinema.domain.MovieRepository
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object ApiFactory:MovieRepository {
    private const val BASE_URL = "https://api.kinopoisk.dev/v1.3/"

    val retrofit: Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
    override fun getMovieList(page:Int) {
        apiService.getMovieList(page)
    }

    override fun getMovieTrailer(idFilm:String) {
        apiService.getMovieTrailer(idFilm)
    }

}