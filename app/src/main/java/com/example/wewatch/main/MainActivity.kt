package com.example.wewatch.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wewatch.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.wewatch.add.AddMovieActivity
import com.example.wewatch.model.LocalDataSource
import com.example.wewatch.model.Movie

class MainActivity : AppCompatActivity(), MainContract.ViewInterface {

    private lateinit var moviesRecyclerView: RecyclerView
    private var adapter: MainAdapter? = null
    private lateinit var fab: FloatingActionButton
    private lateinit var noMoviesLayout: LinearLayout

    private lateinit var dataSource: LocalDataSource

    private val TAG = "MainActivity"

    private lateinit var mainPresenter: MainContract.PresenterInterface

    private fun setupPresenter() {
        val dataSource = LocalDataSource(application)
        mainPresenter = MainPresenter(this, dataSource)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupPresenter()
        setupViews()
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.getMyMoviesList()
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.stop()
    }

    private fun setupViews() {
        moviesRecyclerView = findViewById(R.id.movies_recyclerview)
        moviesRecyclerView.layoutManager = LinearLayoutManager(this)
        fab = findViewById(R.id.fab)
        noMoviesLayout = findViewById(R.id.no_movies_layout)
        supportActionBar?.title = "Movies to Watch"
    }

    override fun displayMovies(movieList: List<Movie>) {
        adapter = MainAdapter(movieList, this@MainActivity)
        moviesRecyclerView.adapter = adapter

        moviesRecyclerView.visibility = VISIBLE
        noMoviesLayout.visibility = INVISIBLE
    }

    override fun displayNoMovies() {
        Log.d(TAG, "No movies to display.")
        moviesRecyclerView.visibility = INVISIBLE
        noMoviesLayout.visibility = VISIBLE
    }

    override fun displayMessage(message: String) {
        Toast.makeText(this, message, Toast. LENGTH_LONG )
            .show()
    }

    //fab onClick
    fun goToAddMovieActivity(v: View) {
        val myIntent = Intent(this@MainActivity, AddMovieActivity::class.java)
        startActivityForResult(myIntent, ADD_MOVIE_ACTIVITY_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_MOVIE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            showToast("Movie successfully added.")
        } else {
            displayError("Movie could not be added.")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.deleteMenuItem) {
            mainPresenter.onDeleteTapped(adapter!!.selectedMovies)
        }
        return super.onOptionsItemSelected(item)
    }

    fun showToast(str: String) {
        Toast.makeText(this@MainActivity, str, Toast.LENGTH_LONG).show()
    }

    override fun displayError(message: String) {
        displayMessage (message)
    }

    companion object {
        const val ADD_MOVIE_ACTIVITY_REQUEST_CODE = 1
    }

}