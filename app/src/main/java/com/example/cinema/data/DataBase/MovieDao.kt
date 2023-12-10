package com.example.cinema.data.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.cinema.data.NetworkEntitys.Movie
import io.reactivex.rxjava3.core.Completable


@Dao

interface MovieDAO {

    @Query("SELECT * FROM favoritMovies")
    fun getAllFavMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM favoritMovies WHERE id=:movieID")
    fun getFavMovie(movieID: Int): LiveData<Movie>

    /*@Query("SELECT * FROM favoritMovies WHERE id =:movieID ")
    fun deleteFromFavoritesByMovieId(movieID: Int): Completable*/

    @Insert
    fun insertToFavorite(movie: Movie): Completable


}
