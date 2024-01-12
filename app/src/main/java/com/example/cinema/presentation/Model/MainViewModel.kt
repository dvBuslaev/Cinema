package com.example.cinema.presentation.Model

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

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    private val compositeDisposable = CompositeDisposable()
    fun loadMovies() {
        if (_isLoading.value == true) {
            return
        }
        val disposable = ApiFactory.apiService.getMovieList(pageQuery).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).doOnSubscribe {
                _isLoading.postValue(true)
            }.doAfterTerminate {
                _isLoading.postValue(false)
            }.subscribe({ it ->
                _movies.value?.let { loadedMovies ->
                    val newMovies = it.movies.filterNot { loadedMovies.contains(it) }
                    loadedMovies.addAll(newMovies)
                    _movies.postValue(loadedMovies)
                } ?: _movies.postValue(it.movies.toMutableList())

                Log.d("TAG", "Loaded: $pageQuery")
                pageQuery++
                Log.d("MainActivity", "${it.movies}")

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