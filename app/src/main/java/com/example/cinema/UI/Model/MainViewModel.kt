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
    private val _movies = MutableLiveData<MutableList<Movie>>()
    val movies: LiveData<MutableList<Movie>>
        get() = _movies

    private val compositeDisposable = CompositeDisposable()
    fun loadMovies() {
        val disposable = ApiFactory.apiService.getMovieList(pageQuery).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _movies.value?.let { loadedMovies ->
                    loadedMovies.addAll(it.movie)
                    _movies.postValue(loadedMovies)
                } ?: _movies.postValue(it.movie.toMutableList())

                Log.d("TAG", "Loaded: $pageQuery")
                pageQuery++
                Log.d("MainActivity", "${it.movie}")

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