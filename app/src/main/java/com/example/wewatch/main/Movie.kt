package com.example.wewatch.main

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
class Movie (@PrimaryKey val id: UUID = UUID.randomUUID(),
             var Title: String = "",
             var Year: String = "",
             var Genres: String = "",
             var Poster: String = "",
             var isWatched: Boolean = false){
}