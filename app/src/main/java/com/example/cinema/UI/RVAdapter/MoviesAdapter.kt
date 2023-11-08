package com.example.cinema.UI.RVAdapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.cinema.R
import com.example.cinema.data.NetworkEntitys.Movie

class MoviesAdapter : ListAdapter<Movie, MoviesViewHolder>(MovieDiffCallback()) {

    var onReachEndScrollListener: OnReachEndScrollListener? = null
    var i = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        Log.d("onCreateViewHolder", "called onCreateViewHolder $i")
        i++
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.movie_item, parent, false
        )
        return MoviesViewHolder(view)
    }




    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        Log.d("onBindViewHolder", "called onBindViewHolder $position")
        val movie = getItem(position)
        val backgroundID = when (movie.rating?.kp ?: 0.0) {
            in 8.0..10.0 -> R.drawable.rating_green
            in 6.0..7.99 -> R.drawable.rating_yellow
            else -> R.drawable.rating_red
        }

        Glide.with(holder.itemView).load(movie.poster?.url).into(holder.ivPoster)
        val formatedRating = "%.1f".format(movie.rating?.kp)
        holder.tvRating.text = formatedRating
        holder.tvRating.setBackgroundResource(backgroundID)
        if (position >= currentList.size - 10) {
            onReachEndScrollListener?.loadMoreItems()
        }
    }

    interface OnReachEndScrollListener {
        fun loadMoreItems() {

        }

    }

}