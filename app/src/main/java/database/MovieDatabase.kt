package com.bignerdranch.android.wewatch.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bignerdranch.android.wewatch.Movie

@Database(entities = [ Movie::class ], version=1)
@TypeConverters(MovieTypeConverters::class)
abstract class MovieDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
}