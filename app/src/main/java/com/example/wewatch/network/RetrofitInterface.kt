package com.bignerdranch.android.wewatch.network

import com.bignerdranch.android.wewatch.database.TmdbResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("search/movie")
    fun searchMovie(@Query("api_key") api_key: String, @Query("query") s: String): Observable<TmdbResponse>
}