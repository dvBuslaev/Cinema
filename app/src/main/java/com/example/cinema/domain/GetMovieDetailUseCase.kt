package com.example.cinema.domain

import com.example.cinema.data.NetworkEntitys.TrailerResponse

class GetMovieDetailUseCase(val repository: MovieRepository) {
    fun getMovieDetail(idFilm:String):List<TrailerResponse>{
        return repository.getMovieTrailer(idFilm)
    }
}