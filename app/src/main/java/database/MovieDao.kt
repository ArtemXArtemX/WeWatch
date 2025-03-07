package com.bignerdranch.android.wewatch.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bignerdranch.android.wewatch.Movie
import java.util.UUID

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie")
    fun getMovies(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie WHERE id=(:id)")
    fun getMovie(id: UUID): LiveData<Movie?>
    @Insert
    fun addMovie(movie: Movie)
}