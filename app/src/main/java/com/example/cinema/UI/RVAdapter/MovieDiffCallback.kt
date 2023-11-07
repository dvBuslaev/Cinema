package com.example.cinema.UI.RVAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cinema.data.NetworkEntitys.Movie

class MovieDiffCallback(
) : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.externalId == newItem.externalId
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}

