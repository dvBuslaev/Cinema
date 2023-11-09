package com.example.cinema.UI.Activitys

import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.R
import com.example.cinema.UI.Model.MainViewModel
import com.example.cinema.UI.RVAdapter.MoviesAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var rvMovieItem: RecyclerView
    private lateinit var viewModel: MainViewModel
    private lateinit var progressBar:ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        viewModel.movies.observe(this) {
            moviesAdapter.submitList(it)

        }
        viewModel.isLoading.observe(this){
            if(it){
                progressBar.visibility=ProgressBar.VISIBLE

            }else{

                progressBar.visibility= ProgressBar.INVISIBLE

            }
        }
        if (savedInstanceState == null) {
            viewModel.loadMovies()
        }

        moviesAdapter.onReachEndScrollListener = object : MoviesAdapter.OnReachEndScrollListener {
            override fun loadMoreItems() {
                viewModel.loadMovies()
            }
        }
    }

    fun initViews() {
        progressBar=findViewById(R.id.progressBarLoading)
        rvMovieItem = findViewById(R.id.recycleViewMovieItem)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        moviesAdapter = MoviesAdapter()
        rvMovieItem.adapter = moviesAdapter
        rvMovieItem.layoutManager = GridLayoutManager(applicationContext, 2)
    }
}