package com.example.cinema.UI.RVAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinema.R
import com.example.cinema.data.NetworkEntitys.Movie

class MoviesAdapter : RecyclerView.Adapter<MoviesViewHolder>() {
     val moviesList = mutableListOf<Movie>()
    val onReachEndScrollListener:OnReachEndScrollListener?=null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_item,
            parent,
            false
        )
        return MoviesViewHolder(view)
    }

    override fun getItemCount() = moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = moviesList[position]
        val backgroundID = when (movie.rating?.kp ?: 0.0) {
            in 8.0..10.0 -> R.drawable.rating_green
            in 6.0..7.99 -> R.drawable.rating_yellow
            else -> R.drawable.rating_red
        }

        Glide.with(holder.itemView).load(movie.poster?.url).into(holder.ivPoster)
        val formatedRating = "%.1f".format(movie.rating?.kp)
        holder.tvRating.text = formatedRating
        holder.tvRating.setBackgroundResource(backgroundID)
    }
    interface OnReachEndScrollListener{
         fun loadMoreItems(){

         }

     }








}