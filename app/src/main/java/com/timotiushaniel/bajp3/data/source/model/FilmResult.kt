package com.timotiushaniel.bajp3.data.source.model

import com.google.gson.annotations.SerializedName

data class FilmResult(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title", alternate = ["name"])
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("backdrop_path")
    val backdropPath: String,
)