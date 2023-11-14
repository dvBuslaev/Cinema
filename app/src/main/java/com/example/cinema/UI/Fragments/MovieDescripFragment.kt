package com.example.cinema.UI.Fragments

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinema.R
import com.example.cinema.UI.Model.MainViewModel
import com.example.cinema.UI.Model.MovieDescrViewModel
import com.example.cinema.UI.RVAdapter.MoviesAdapter
import com.example.cinema.UI.RVAdapter.TrailerAdapter
import com.example.cinema.data.NetworkEntitys.Movie
import com.example.cinema.data.NetworkEntitys.Poster
import java.io.Serializable


class MovieDescripFragment : Fragment() {
    private lateinit var ivPoster: ImageView
    private lateinit var tvYear: TextView
    private lateinit var viewModel: MovieDescrViewModel
    private lateinit var tvDescription: TextView
    private lateinit var tvName: TextView
    private lateinit var rvTrailers:RecyclerView
    private lateinit var trailerAdapter: TrailerAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
               return inflater.inflate(R.layout.fragment_movie_descrip, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setViews()
        viewModel.trailers.observe(viewLifecycleOwner){
            trailerAdapter.submitList(it)
        }

    }
    companion object {
        private const val MOVIE = "movie"
        fun newInstance(
            movie:Movie,
        ): MovieDescripFragment {
            return MovieDescripFragment().apply {
                arguments = Bundle().apply {
                   putParcelable(MOVIE,movie)
                }
            }
        }
    }
    private fun setViews() {
        arguments?.let {
            val movie:Movie? = it.getParcelable(MOVIE)
            val poster=movie?.poster?.url
            tvName.text=movie?.name
            tvDescription.text=movie?.description
            Glide.with(this).load(poster).into(ivPoster)
            viewModel.loadTrailer(movie?.id.toString())
        }
    }
    private fun parseParams() {
        if (!requireArguments().containsKey(MOVIE) ) {
            throw RuntimeException("Missing required params")
        }
    }
    private fun initViews(view: View) {
        viewModel = ViewModelProvider(requireActivity())[MovieDescrViewModel::class.java]
        ivPoster = view.findViewById(R.id.imageViewPosterfragment)
        tvYear = view.findViewById(R.id.textViewYear)
        tvDescription = view.findViewById(R.id.textVIewMovieDescription)
        tvName = view.findViewById(R.id.textViewMovieName)
        rvTrailers=view.findViewById(R.id.recyclerViewTrailers)
        trailerAdapter=TrailerAdapter()
        rvTrailers.adapter=trailerAdapter
    }
}