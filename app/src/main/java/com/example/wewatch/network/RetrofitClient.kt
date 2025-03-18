package com.bignerdranch.android.wewatch.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    // http://www.omdbapi.com/?i=tt3896198&apikey=e45f429b
    const val API_KEY = "e45f429b"
    const val TMDB_BASE_URL = "https://www.omdbapi.com/"
    const val TMDB_IMAGEURL = "https://m.media-amazon.com/images/M/"

    val moviesApi = Retrofit.Builder()
        .baseUrl(TMDB_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(RetrofitInterface::class.java)
}