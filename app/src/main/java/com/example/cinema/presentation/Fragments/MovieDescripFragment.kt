package com.example.cinema.presentation.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.cinema.presentation.Model.MovieDescrViewModel
import com.example.cinema.presentation.RVAdapter.TrailerAdapter
import com.example.cinema.data.NetworkEntitys.Movie
import com.example.cinema.data.NetworkEntitys.Trailers
import com.example.cinema.databinding.FragmentMovieDescripBinding


class MovieDescripFragment : Fragment() {

    private lateinit var viewModel: MovieDescrViewModel
    private lateinit var trailerAdapter: TrailerAdapter
    private lateinit var onTrailerClickListener: OnTrailerClickListener
    private var _binding: FragmentMovieDescripBinding? = null
    private val binding: FragmentMovieDescripBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnTrailerClickListener) onTrailerClickListener = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDescripBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        setViews()
        viewModel.trailers.observe(viewLifecycleOwner) {
            trailerAdapter.submitList(it)
        }
        trailerAdapter.onTrailerClickListener = {
            onTrailerClickListener.onTrailerClicked(it)

        }
        binding.imageViewStar.setOnClickListener {


        }

    }

    companion object {
        private const val MOVIE = "movie"
        fun newInstance(
            movie: Movie,
        ): MovieDescripFragment {
            return MovieDescripFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(MOVIE, movie)
                }
            }
        }
    }

    private fun setViews() {
        arguments?.let {
            val movie: Movie? = it.getParcelable(MOVIE)
            val poster = movie?.poster?.url
            binding.textViewMovieName.text = movie?.name
            binding.textVIewMovieDescription.text = movie?.description
            Glide.with(this).load(poster).into(binding.imageViewPosterfragment)
            viewModel.loadTrailer(movie?.id.toString())


        }
    }

    private fun parseParams() {
        if (!requireArguments().containsKey(MOVIE)) {
            throw RuntimeException("Missing required params")
        }
    }

    private fun initViews() {
        viewModel = ViewModelProvider(requireActivity())[MovieDescrViewModel::class.java]
        trailerAdapter = TrailerAdapter()
        binding.recyclerViewTrailers.adapter = trailerAdapter


    }

    interface OnTrailerClickListener {
        fun onTrailerClicked(item: Trailers)
        fun onStarClicked(movie: Movie)

    }
}