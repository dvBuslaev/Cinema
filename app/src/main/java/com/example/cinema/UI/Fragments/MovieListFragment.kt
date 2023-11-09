package com.example.cinema.UI.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.R
import com.example.cinema.UI.Model.MainViewModel
import com.example.cinema.UI.RVAdapter.MoviesAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var movieName: String? = null
    private var movieDescription: String? = null
    private var movieYear: String? = null
    private var moviePoster: String? = null
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var rvMovieItem: RecyclerView
    private lateinit var viewModel: MainViewModel
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /*parseParams()*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    companion object {
        private const val SCREEN_MODE = "extra_mode"
        private const val MOVIE_ID = "MOVIE_ID"
        private const val MOVIE_DESCRIPTION = "MOVIE_DESCRIPTION"
        private const val MOVIE_NAME = "MOVIE_NAME"
        private const val MODE_UNKNOWN = ""
        private const val MOVIE_YEAR = "MOVIE_YEAR"
        private const val MOVIE_POSTER = "MOVIE_POSTER"


        /*@JvmStatic*/
        fun newInstance(
            /*movieName: String,
            movieDescription: String,
            movieYear: String,
            moviePoster: String*/
        ): MovieListFragment {
            return MovieListFragment().apply {
                arguments = Bundle().apply {
                   /* putString(MOVIE_DESCRIPTION, movieDescription)
                    putString(MOVIE_POSTER, moviePoster)
                    putString(MOVIE_NAME, movieName)
                    putString(MOVIE_YEAR, movieYear)*/
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
        viewModel.isLoading.observe(viewLifecycleOwner){
            if(it){
                progressBar.visibility=ProgressBar.VISIBLE

            }else{

                progressBar.visibility= ProgressBar.INVISIBLE

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
    }
    private fun initViews(view: View) {
        progressBar=view.findViewById(R.id.progressBarLoading)
        rvMovieItem = view.findViewById(R.id.recycleViewMovieItem)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        moviesAdapter = MoviesAdapter()
        rvMovieItem.adapter = moviesAdapter
        rvMovieItem.layoutManager = GridLayoutManager(activity, 2)
    }

    /*private fun parseParams() {
        val args = requireArguments()
        if (!args.containsKey(MOVIE_DESCRIPTION) && !args.containsKey(MOVIE_NAME) && !args.containsKey(
                MOVIE_YEAR
            ) && !args.containsKey(MOVIE_POSTER)
        ) {
            throw RuntimeException("Missing required params")
        }
    }*/
}