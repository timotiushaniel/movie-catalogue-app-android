package com.timotiushaniel.bajp3.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity

@Dao
interface FilmDao {

    @Query("SELECT * FROM movieentity")
    fun getMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentity")
    fun getTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShows: List<TvShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)

    @Query("SELECT * FROM movieentity WHERE isFavorite = 1")
    fun getFavoriteMovies(): DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM tvshowentity WHERE isFavorite = 1")
    fun getFavoriteTvShows(): DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM movieentity WHERE movieId = :id")
    fun getMovieById(id: Int): LiveData<MovieEntity>

    @Query("SELECT * FROM tvshowentity WHERE tvShowId = :id")
    fun getTvShowById(id: Int): LiveData<TvShowEntity>
}