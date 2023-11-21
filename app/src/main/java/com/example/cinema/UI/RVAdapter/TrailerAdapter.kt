package com.example.cinema.UI.RVAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cinema.R
import com.example.cinema.data.NetworkEntitys.Trailers

class TrailerAdapter:ListAdapter<Trailers,TrailerViewHolder>(TrailerDiffCallback()) {

    var ontrailerClickListener: ((Trailers) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.trailer_item, parent, false
        )
        return TrailerViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrailerViewHolder, position: Int) {
        val trailer=getItem(position)
        holder.trailerName.text=trailer.name.toString()
        holder.itemView.setOnClickListener {
            ontrailerClickListener?.invoke(trailer)
        }
    }





    interface OnTrailerClickListener{
           fun onClick()
    }

    }
