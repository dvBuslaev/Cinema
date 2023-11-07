package com.example.cinema.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.cinema.R
import com.example.cinema.UI.Model.MainViewModel
import com.example.cinema.data.ApiService.ApiFactory
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewmodel= ViewModelProvider(this).get(MainViewModel::class.java)
        viewmodel.loadMovies()
        /*ApiFactory.apiService.getMovieList(*//*viewmodel.pageQuery*//*).subscribeOn(Schedulers.io()).observeOn(
            AndroidSchedulers.mainThread())
          .subscribe({it-> Log.d("MainActivity","${it}")


          },{
              throw Exception("$it - exeption")
          })*/
    }
}