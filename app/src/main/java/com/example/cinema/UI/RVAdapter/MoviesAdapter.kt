package com.example.cinema.UI.RVAdapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.data.NetworkEntitys.Movie

class MoviesAdapter: RecyclerView.Adapter<MoviesViewHolder>() {
    private val moviesList = ArrayList<Movie>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount()=moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}