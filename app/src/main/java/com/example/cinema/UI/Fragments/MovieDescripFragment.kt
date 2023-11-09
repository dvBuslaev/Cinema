package com.example.cinema.UI.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.cinema.R
import com.example.cinema.UI.Model.MainViewModel


class MovieDescripFragment : Fragment() {
    private lateinit var ivPoster: ImageView
    private lateinit var tvYear: TextView
    private lateinit var viewModel: MainViewModel
    private lateinit var tvDescription: TextView
    private lateinit var tvName: TextView


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
        Log.d("MovieDescripFragment","I WAS CREATED")
        val args = requireArguments()
        initViews(view)
        setViews(args)
        Glide.with(ivPoster.context).load(args.getString(MOVIE_POSTER)).into(ivPoster)

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
            movieName: String,
            movieDescription: String,
            movieYear: String,
            moviePoster: String
        ): MovieDescripFragment {
            return MovieDescripFragment().apply {
                arguments = Bundle().apply {
                    putString(MOVIE_DESCRIPTION, movieDescription)
                    putString(MOVIE_POSTER, moviePoster)
                    putString(MOVIE_NAME, movieName)
                    putString(MOVIE_YEAR, movieYear)
                }
            }
        }
    }

    private fun parseParams() {
        val args = requireArguments()
        if (!args.containsKey(MOVIE_DESCRIPTION) && !args.containsKey(MOVIE_NAME) && !args.containsKey(
                MOVIE_YEAR
            ) && !args.containsKey(MOVIE_POSTER)
        ) {
            throw RuntimeException("Missing required params")
        }


    }

    private fun setViews(args: Bundle?) {

        tvYear.text = args?.getString(MOVIE_YEAR).toString()
        tvDescription.text = args?.getString(MOVIE_DESCRIPTION).toString()
        tvName.text = args?.getString(MOVIE_NAME).toString()
    }

    private fun initViews(view: View) {
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        ivPoster = view.findViewById(R.id.imageViewPosterfragment)
        tvYear = view.findViewById(R.id.textViewYear)
        tvDescription = view.findViewById(R.id.textVIewMovieDescription)
        tvName = view.findViewById(R.id.textViewMovieName)
    }
}