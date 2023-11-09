package com.example.cinema.UI.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cinema.R

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

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MovieList.
         */
        // TODO: Rename and change types and number of parameters
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