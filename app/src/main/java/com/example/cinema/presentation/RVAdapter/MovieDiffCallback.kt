package com.example.cinema.presentation.RVAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cinema.data.NetworkEntitys.Movie

class MovieDiffCallback(
) : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}

