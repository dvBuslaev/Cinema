package com.example.cinema.presentation.Activitys

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cinema.R
import com.example.cinema.presentation.Fragments.MovieDescripFragment
import com.example.cinema.presentation.Fragments.MovieListFragment
import com.example.cinema.data.NetworkEntitys.Movie
import com.example.cinema.data.NetworkEntitys.Trailers

class MainActivity : AppCompatActivity(), MovieListFragment.OnMovieFragmentInteractionListener,
    MovieDescripFragment.OnTrailerClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchFragment(MovieListFragment.newInstance())


    }

    override fun onMovieClick(movie: Movie) {
        launchFragment2(MovieDescripFragment.newInstance(movie))

    }

    override fun onTrailerClicked(item: Trailers) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(item.url)
        startActivity(intent)
        Log.d("onClicked", "${intent.data}")
    }

    override fun onStarClicked(movie: Movie) {
        TODO("Not yet implemented")
    }


    private fun launchFragment(fragment: Fragment) {
        //supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null).commit()
    }

    private fun launchFragment2(fragment: Fragment) {
        // supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null).commit()
    }


}