package com.example.cinema.UI.RVAdapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cinema.data.NetworkEntitys.Trailers

class TrailerDiffCallback:DiffUtil.ItemCallback<Trailers>() {
    override fun areItemsTheSame(oldItem: Trailers, newItem: Trailers): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: Trailers, newItem: Trailers): Boolean {
        return oldItem == newItem
    }
}