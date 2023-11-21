package com.example.cinema.UI.RVAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cinema.data.NetworkEntitys.Moviee

class MovieDiffCallback(
) : DiffUtil.ItemCallback<Moviee>() {
    override fun areItemsTheSame(oldItem: Moviee, newItem: Moviee): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Moviee, newItem: Moviee): Boolean {
        return oldItem == newItem
    }

}

