package com.timotiushaniel.bajp3.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity
import com.timotiushaniel.bajp3.vo.Resource

interface ItemDataSource {
    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>>

    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>>

    fun getDetailMovies(movieId: Int): LiveData<Resource<MovieEntity>>

    fun getDetailTVShows(tvId: Int): LiveData<Resource<TvShowEntity>>

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>

    fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>>

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean)
}