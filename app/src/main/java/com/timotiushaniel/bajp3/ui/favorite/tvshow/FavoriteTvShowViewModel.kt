package com.timotiushaniel.bajp3.ui.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.timotiushaniel.bajp3.data.FilmRepository
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity

class FavoriteTvShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {
    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> = filmRepository.getFavoriteTvShow()

    fun setFavoriteTvShows(tvShowEntity: TvShowEntity) {
        val newState = !tvShowEntity.isFavorite
        filmRepository.setFavoriteTvShow(tvShowEntity, newState)
    }
}