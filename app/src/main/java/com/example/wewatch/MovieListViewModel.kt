package com.bignerdranch.android.wewatch

import androidx.lifecycle.ViewModel

class MovieListViewModel: ViewModel() {
    private val movieRepository = MovieRepository.get()
    val movieListLiveData = movieRepository.getMovies()
    fun addMovie(movie: Movie) {
        movieRepository.addCrime(movie)
    }
}