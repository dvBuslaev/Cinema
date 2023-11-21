package com.example.cinema.UI.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cinema.R
import com.example.cinema.UI.Model.MovieDescrViewModel
import com.example.cinema.UI.RVAdapter.TrailerAdapter
import com.example.cinema.data.NetworkEntitys.Moviee
import com.example.cinema.data.NetworkEntitys.Trailers


class MovieDescripFragment : Fragment() {
    private lateinit var ivPoster: ImageView
    private lateinit var tvYear: TextView
    private lateinit var viewModel: MovieDescrViewModel
    private lateinit var tvDescription: TextView
    private lateinit var tvName: TextView
    private lateinit var ivStar: ImageView
    private lateinit var rvTrailers: RecyclerView
    private lateinit var trailerAdapter: TrailerAdapter
    private lateinit var onTrailerClickListener: OnTrailerClickListener


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnTrailerClickListener)
            onTrailerClickListener = context
    }

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
        viewModel.trailers.observe(viewLifecycleOwner) {
            trailerAdapter.submitList(it)
        }
        trailerAdapter.ontrailerClickListener = {
            onTrailerClickListener.onTrailerClicked(it)

        }
        ivStar.setOnClickListener {


        }

    }

    companion object {
        private const val MOVIE = "movie"
        fun newInstance(
            moviee: Moviee,
        ): MovieDescripFragment {
            return MovieDescripFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MOVIE, moviee)
                }
            }
        }
    }

    private fun setViews() {
        arguments?.let {
            val moviee: Moviee? = it.getParcelable(MOVIE)
            val poster = moviee?.poster?.url
            tvName.text = moviee?.name
            tvDescription.text = moviee?.description
            Glide.with(this).load(poster).into(ivPoster)
            viewModel.loadTrailer(moviee?.id.toString())


        }
    }

    private fun parseParams() {
        if (!requireArguments().containsKey(MOVIE)) {
            throw RuntimeException("Missing required params")
        }
    }

    private fun initViews(view: View) {
        viewModel = ViewModelProvider(requireActivity())[MovieDescrViewModel::class.java]
        ivPoster = view.findViewById(R.id.imageViewPosterfragment)
        tvYear = view.findViewById(R.id.textViewYear)
        tvDescription = view.findViewById(R.id.textVIewMovieDescription)
        tvName = view.findViewById(R.id.textViewMovieName)
        rvTrailers = view.findViewById(R.id.recyclerViewTrailers)
        ivStar = view.findViewById(R.id.imageViewStar)
        trailerAdapter = TrailerAdapter()
        rvTrailers.adapter = trailerAdapter


    }

    interface OnTrailerClickListener {
        fun onTrailerClicked(item: Trailers)
        fun onStarClicked(moviee: Moviee)

    }
}