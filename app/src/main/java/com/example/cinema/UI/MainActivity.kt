package com.example.cinema.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.R
import com.example.cinema.UI.Model.MainViewModel
import com.example.cinema.UI.RVAdapter.MoviesAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var moviesAdapter: MoviesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        val rvMovieItem: RecyclerView = findViewById(R.id.recycleViewMovieItem)
        rvMovieItem.layoutManager = GridLayoutManager(applicationContext, 2);
        moviesAdapter = MoviesAdapter()
        rvMovieItem.adapter = moviesAdapter


        viewModel.movies.observe(this) {  movieList ->


            moviesAdapter.moviesList.addAll(movieList)
            moviesAdapter.notifyDataSetChanged()

            }



        viewModel.loadMovies()
        moviesAdapter.onReachEndScrollListener = object : MoviesAdapter.OnReachEndScrollListener {
            override fun loadMoreItems() {
                viewModel.loadMovies()
            }
        }
    }
}