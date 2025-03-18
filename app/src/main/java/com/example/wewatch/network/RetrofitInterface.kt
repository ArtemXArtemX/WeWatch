package com.example.wewatch.network

import com.example.wewatch.model.TmdbResponse
import com.example.wewatch.network.RetrofitClient.API_KEY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET("/")
    fun searchMovie(@Query("apikey") api_key: String, @Query("s") s: String): Observable<TmdbResponse>
}
