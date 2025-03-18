package com.example.wewatch.main

import com.example.wewatch.model.Movie

class MainContract {
    interface PresenterInterface {

        //TODO: добавить методы интерфейса для Presenter
        fun getMyMoviesList()
        fun stop()
        fun onDeleteTapped(selectedMovies: HashSet<*>)
    }
    interface ViewInterface {
        fun displayMovies (movieList: List <Movie>)
        fun displayNoMovies ()
        fun displayMessage (message: String )
        fun displayError (message: String )
    }
}