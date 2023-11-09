package com.example.cinema.UI.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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

    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var rvMovieItem: RecyclerView
    private lateinit var viewModel: MainViewModel
    private lateinit var progressBar: ProgressBar
    private lateinit var poster:ImageView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    companion object {

        fun newInstance(

        ): MovieListFragment {
            return MovieListFragment().apply {
                arguments = Bundle().apply {

                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        setupClickListener()



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


    }

    private fun initViews(view: View) {

        progressBar = view.findViewById(R.id.progressBarLoading)
        rvMovieItem = view.findViewById(R.id.recycleViewMovieItem)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        moviesAdapter = MoviesAdapter()
        rvMovieItem.adapter = moviesAdapter
        rvMovieItem.layoutManager = GridLayoutManager(activity, 2)
    }
    fun setupClickListener(){
        moviesAdapter.onMovieClickListener={
            Log.d("setupClickListener","clicked")
            val fragment = MovieDescripFragment.newInstance("movie name","once apon the time","2007","https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/4fe19ade-348a-404f-b35f-32616017ce91/x1000")
            lounchSecondFragment(fragment)




        }
    }
    fun lounchSecondFragment(transaction:Fragment) {
        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentMovieDescr, transaction)
            ?.addToBackStack(null) // Добавьте эту строку, если вы хотите добавить транзакцию в стек возврата назад
            ?.commit()
    }


}