package com.bignerdranch.android.wewatch

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Year
import java.util.Date
import java.util.UUID

@Entity
class Movie (@PrimaryKey val id: UUID = UUID.randomUUID(),
             var title: String = "",
             var year: String = "",
             var urlImage: String = "",
             var isWatched: Boolean = false){
}

