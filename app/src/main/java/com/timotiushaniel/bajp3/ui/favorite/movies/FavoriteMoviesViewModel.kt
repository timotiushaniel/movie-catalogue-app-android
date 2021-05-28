package com.timotiushaniel.bajp3.ui.favorite.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.timotiushaniel.bajp3.data.FilmRepository
import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity

class FavoriteMoviesViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = filmRepository.getFavoriteMovie()

    fun setFavoriteMovies(moviesEntity: MovieEntity) {
        val newState = !moviesEntity.isFavorite
        filmRepository.setFavoriteMovie(moviesEntity, newState)
    }
}