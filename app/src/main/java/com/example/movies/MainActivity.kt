package com.example.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FragmentMoviesDetails.TransactionsFragmentClicks,
    FragmentMoviesList.TransactionsFragmentClicks {

    private val moviesDetailsFragment =
        FragmentMoviesDetails().apply { setClickListener(this@MainActivity) }
    private val moviesListFragment =
        FragmentMoviesList().apply { setClickListener(this@MainActivity) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       if(savedInstanceState == null) {
           supportFragmentManager.beginTransaction()
               .add(R.id.main_container, moviesListFragment)
               .commit()
       }
    }

    override fun goBack() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_container, moviesListFragment)
            .commit()
    }

    override fun open() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_container, moviesDetailsFragment)
            .commit()
    }
}