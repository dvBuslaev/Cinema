package com.example.cinema.UI.Model


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cinema.data.ApiService.ApiFactory
import com.example.cinema.data.NetworkEntitys.Trailers

import com.example.cinema.data.NetworkEntitys.Videos
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieDescrViewModel:ViewModel() {
    val trailers: LiveData<MutableList<Trailers>>
        get() = _trailers
    private val _trailers = MutableLiveData<MutableList<Trailers>>()
    private val compositeDisposable = CompositeDisposable()
    fun loadTrailer(movieID: String) {
        val disposable = ApiFactory.apiService.getMovieTrailer(movieID).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            /*.map {  }*/
            .subscribe({
                       _trailers.postValue(it.videos?.trailers?.toMutableList())

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