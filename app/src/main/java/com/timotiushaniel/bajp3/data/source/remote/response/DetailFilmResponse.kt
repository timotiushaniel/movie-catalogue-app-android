package com.timotiushaniel.bajp3.data.source.remote.response

import com.google.gson.annotations.SerializedName
import com.timotiushaniel.bajp3.data.source.model.Genre

data class DetailFilmResponse(

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("title", alternate = ["name"])
    val title: String?,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("release_date", alternate = ["first_air_date"])
    val releaseDate: String?,

    @SerializedName("genres")
    val genres: List<Genre>?,

    @SerializedName("vote_average")
    val voteAverage: Double?,

    @SerializedName("id")
    val id: Int?,
)


