package com.example.cinema.UI.Activitys

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cinema.R
import com.example.cinema.UI.Fragments.MovieDescripFragment
import com.example.cinema.UI.Fragments.MovieListFragment
import com.example.cinema.UI.Model.MainViewModel
import com.example.cinema.UI.RVAdapter.MoviesAdapter
import com.example.cinema.data.NetworkEntitys.Movie

class MainActivity : AppCompatActivity(),MovieListFragment.OnMovieFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchFragment(MovieListFragment.newInstance())

    }

    override fun onMovieClick(movie: Movie) {
        Log.d("onMovieClick", movie.poster.toString())

    launchFragment2(MovieDescripFragment.newInstance(movie))

    }


    private fun launchFragment(fragment: Fragment) {
        //supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
    private fun launchFragment2(fragment: Fragment) {
       // supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}