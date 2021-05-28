package com.timotiushaniel.bajp3.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentity")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    val id: Int?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "overview")
    val overview: String?,
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double?,
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false,
    @ColumnInfo(name = "genres")
    val genre: String?,
    @ColumnInfo(name = "release_date")
    val releaseYear: String?,
    @ColumnInfo(name = "backdrop_path")
    val backdropPath: String?,
    @ColumnInfo(name = "poster_path")
    val posterPath: String?,
)