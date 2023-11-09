package com.example.cinema.UI.Activitys

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.cinema.R
import com.example.cinema.UI.Fragments.MovieDescripFragment
import com.example.cinema.UI.Fragments.MovieListFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchFragment(MovieListFragment.newInstance())
        //launchFragment2(MovieDescripFragment.newInstance("movie name","once apon the time","2007","https://avatars.mds.yandex.net/get-kinopoisk-image/1599028/4fe19ade-348a-404f-b35f-32616017ce91/x1000"))
    }



    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentMovieList, fragment)
            .addToBackStack(null)
            .commit()
    }
    private fun launchFragment2(fragment: Fragment) {
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentMovieDescr, fragment)
            .addToBackStack(null)
            .commit()
    }
}