package com.example.cinema.UI.Fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.R
import com.example.cinema.UI.Model.MainViewModel
import com.example.cinema.UI.RVAdapter.MoviesAdapter
import com.example.cinema.data.NetworkEntitys.Movie
import com.example.cinema.data.NetworkEntitys.MovieResponse

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment() {

    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var rvMovieItem: RecyclerView
    private lateinit var viewModel: MainViewModel
    private lateinit var progressBar: ProgressBar
    private lateinit var onMovieFragmentInteractionListener: OnMovieFragmentInteractionListener


    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnMovieFragmentInteractionListener) {
            onMovieFragmentInteractionListener=context
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movie_list, container, false)
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
        initViews(view)


        viewModel.movies.observe(viewLifecycleOwner) {
            moviesAdapter.submitList(it)

        }
        viewModel.isLoading.observe(viewLifecycleOwner) {
            if (it) {
                progressBar.visibility = ProgressBar.VISIBLE

            } else {

                progressBar.visibility = ProgressBar.INVISIBLE

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
        moviesAdapter.onMovieClickListener={
            onMovieFragmentInteractionListener.onMovieClick(it)
            Log.d("onMovieFragmentInteractionListener","clicked on ${it.name}")
    }

    }

    private fun initViews(view: View) {

        progressBar = view.findViewById(R.id.progressBarLoading)
        rvMovieItem = view.findViewById(R.id.recycleViewMovieItem)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        moviesAdapter = MoviesAdapter()
        rvMovieItem.adapter = moviesAdapter
        rvMovieItem.layoutManager = GridLayoutManager(activity, 2)
    }

    interface OnMovieFragmentInteractionListener {
        fun onMovieClick(movie: Movie)
    }


}