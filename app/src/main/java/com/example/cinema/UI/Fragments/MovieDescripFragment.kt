package com.example.cinema.UI.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cinema.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MovieDescripFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieDescripFragment : Fragment() {

    private var movieName: String? = null
    private var movieDescription: String? = null
    private var movieYear: String? = null
    private var moviePoster: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parseParams()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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
            movieName: String,
            movieDescription: String,
            movieYear: String,
            moviePoster: String
        ): MovieListFragment {
            return MovieListFragment().apply {
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
}