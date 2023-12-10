package com.example.cinema.UI.Fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cinema.UI.Model.MainViewModel
import com.example.cinema.UI.RVAdapter.MoviesAdapter
import com.example.cinema.data.NetworkEntitys.Movie
import com.example.cinema.databinding.FragmentMovieListBinding

class MovieListFragment : Fragment() {

    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var viewModel: MainViewModel
    private lateinit var onMovieFragmentInteractionListener: OnMovieFragmentInteractionListener
    private var _binding: FragmentMovieListBinding? = null
    private val binding: FragmentMovieListBinding
        get() = _binding ?: throw RuntimeException("FragmentWelcomeBinding == null")


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnMovieFragmentInteractionListener) {
            onMovieFragmentInteractionListener = context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        fun newInstance(
            //movieList: MovieResponse
        ): MovieListFragment {
            return MovieListFragment().apply {
                arguments = Bundle().apply {
                    //putSerializable("MOVIE", movieList);

                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()


        viewModel.movies.observe(viewLifecycleOwner) {
            moviesAdapter.submitList(it)

        }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBarLoading.visibility = ProgressBar.VISIBLE

            } else {

                binding.progressBarLoading.visibility = ProgressBar.INVISIBLE

            }
        }
        if (savedInstanceState == null) {
            viewModel.loadMovies()
        }

        moviesAdapter.onReachEndScrollListener = object : MoviesAdapter.OnReachEndScrollListener {
            override fun loadMoreItems() {
                viewModel.loadMovies()
            }
        }
        moviesAdapter.onMovieClickListener = {
            onMovieFragmentInteractionListener.onMovieClick(it)
            Log.d("onMovieFragmentInteractionListener", "clicked on ${it.name}")

        }

    }

    private fun initViews() {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        moviesAdapter = MoviesAdapter()
        binding.recycleViewMovieItem.adapter = moviesAdapter
        binding.recycleViewMovieItem.layoutManager = GridLayoutManager(activity, 2)
    }

    interface OnMovieFragmentInteractionListener {
        fun onMovieClick(movie: Movie)
    }


}