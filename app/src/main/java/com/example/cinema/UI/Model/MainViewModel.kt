package com.example.cinema.UI.Model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.data.ApiService.ApiFactory
import com.example.cinema.data.NetworkEntitys.Movie
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {
    var pageQuery = 1
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>>
        get() = _movies

    val compositeDisposable = CompositeDisposable()
    fun loadMovies() {
        val disposable = ApiFactory.apiService.getMovieList(pageQuery).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { movieList ->
                movieList.movie.filter { movie -> movie.poster != null }
            }
            .subscribe({ filteredMovieList ->
                _movies.postValue(filteredMovieList)
                pageQuery++
                Log.d("MainActivity", "$filteredMovieList")
                Log.d("MainActivity", "${pageQuery}")

            }, { e ->
                e.printStackTrace()
            })

        compositeDisposable.add(disposable)


    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}