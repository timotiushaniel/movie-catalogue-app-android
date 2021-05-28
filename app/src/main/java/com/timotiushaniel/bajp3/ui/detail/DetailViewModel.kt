package com.timotiushaniel.bajp3.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.timotiushaniel.bajp3.data.FilmRepository
import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity
import com.timotiushaniel.bajp3.vo.Resource
import timber.log.Timber
import kotlin.properties.Delegates

class DetailViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    private var moviesId by Delegates.notNull<Int>()
    private var tvShowId by Delegates.notNull<Int>()
    private lateinit var movies: LiveData<Resource<MovieEntity>>
    private lateinit var tvShows: LiveData<Resource<TvShowEntity>>

    fun setSelectedMovies(moviesId: Int) {
        this.moviesId = moviesId
        movies = filmRepository.getDetailMovies(moviesId)
    }

    fun setSelectedTvShow(tvShowId: Int) {
        this.tvShowId = tvShowId
        tvShows = filmRepository.getDetailTVShows(tvShowId)
    }

    fun getMoviesDetail() = movies

    fun getTvShowDetail() = tvShows

    fun setFavoriteMovie() {
        val resource = movies.value
        Timber.d("Resource: $resource")
        if (resource?.data != null) {
            val newState = !resource.data.isFavorite
            filmRepository.setFavoriteMovie(resource.data, newState)
        }
    }

    fun setFavoriteTvShow() {
        val resource = tvShows.value
        Timber.d("Resource: $resource")
        if (resource?.data != null) {
            val newState = !resource.data.isFavorite
            filmRepository.setFavoriteTvShow(resource.data, newState)
        }
    }

    companion object {
        const val MOVIE = "movie"
        const val TV_SHOW = "tvShow"
    }
}