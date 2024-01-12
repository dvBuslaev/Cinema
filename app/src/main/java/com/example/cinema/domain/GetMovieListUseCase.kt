package com.example.cinema.domain

import com.example.cinema.data.NetworkEntitys.Movie

class GetMovieListUseCase(val repository: MovieRepository) {
    fun getMovieList(page: Int): List<Movie>{
        return repository.getMovieList(page)
    }
}