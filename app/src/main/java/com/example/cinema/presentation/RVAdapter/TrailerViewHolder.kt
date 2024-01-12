package com.example.cinema.presentation.RVAdapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.R

class TrailerViewHolder(view:View):RecyclerView.ViewHolder(view) {
    val trailerName = view.findViewById<TextView>(R.id.textViewTrailerName)



}