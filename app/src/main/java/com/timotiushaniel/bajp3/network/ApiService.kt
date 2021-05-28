package com.timotiushaniel.bajp3.network

import com.timotiushaniel.bajp3.data.source.remote.response.DetailFilmResponse
import com.timotiushaniel.bajp3.data.source.remote.response.FilmResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    fun getMovies(
        @Query("api_key") apiKey: String
    ): Call<FilmResponse>

    @GET("movie/{id}")
    fun getMovieDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String
    ): Call<DetailFilmResponse>

    @GET("discover/tv")
    fun getTvShows(
        @Query("api_key") apiKey: String
    ): Call<FilmResponse>

    @GET("tv/{id}")
    fun getTvShowDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String
    ): Call<DetailFilmResponse>
}