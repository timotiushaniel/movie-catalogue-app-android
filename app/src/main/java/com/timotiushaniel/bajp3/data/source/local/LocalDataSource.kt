package com.timotiushaniel.bajp3.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity
import com.timotiushaniel.bajp3.data.source.local.room.FilmDao

class LocalDataSource private constructor(private val mFilmDao: FilmDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(mFilmDao: FilmDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(mFilmDao)
    }

    fun getMovies(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getMovies()

    fun getTvShows(): DataSource.Factory<Int, TvShowEntity> = mFilmDao.getTvShows()

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = mFilmDao.getFavoriteMovies()

    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity> = mFilmDao.getFavoriteTvShows()

    fun setFavoriteMovie(movieEntity: MovieEntity, newState: Boolean) {
        movieEntity.isFavorite = newState
        mFilmDao.updateMovie(movieEntity)
    }

    fun setFavoriteTvShow(tvShowEntity: TvShowEntity, newState: Boolean) {
        tvShowEntity.isFavorite = newState
        mFilmDao.updateTvShow(tvShowEntity)
    }

    fun insertMovie(movies: List<MovieEntity>) = mFilmDao.insertMovies(movies)

    fun insertTvShow(tvShow: List<TvShowEntity>) = mFilmDao.insertTvShow(tvShow)

    fun getMovieById(id: Int): LiveData<MovieEntity> = mFilmDao.getMovieById(id)

    fun getTvShowById(id: Int): LiveData<TvShowEntity> = mFilmDao.getTvShowById(id)

    fun updateMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        mFilmDao.updateMovie(movie)
    }

    fun updateTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        mFilmDao.updateTvShow(tvShow)
    }
}