package com.example.cinema.presentation.Model


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.data.ApiService.ApiFactory
import com.example.cinema.data.NetworkEntitys.Trailers
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDescrViewModel : ViewModel() {

    val trailers: LiveData<MutableList<Trailers>>
        get() = _trailers
    private val _trailers = MutableLiveData<MutableList<Trailers>>()
    private val compositeDisposable = CompositeDisposable()
    fun loadTrailer(movieID: String) {
        Log.d("MovieDescrViewModel", "started")
        val disposable = ApiFactory.apiService.getMovieTrailer(movieID).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).map {
                it.videos?.trailers?.toMutableList() ?: mutableListOf()
            }.subscribe({
                _trailers.postValue(it)
                Log.d("MovieDescrViewModel", "$it")
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