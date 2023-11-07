package com.example.cinema.UI.RVAdapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.R
import com.example.cinema.data.NetworkEntitys.Movie

class MoviesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val ivPoster = view.findViewById<ImageView>(R.id.imageViewPoster)
    val tvRating = view.findViewById<TextView>(R.id.textViewRating)

}