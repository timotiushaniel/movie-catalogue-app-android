package com.timotiushaniel.bajp3.ui.home.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.timotiushaniel.bajp3.data.FilmRepository
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity
import com.timotiushaniel.bajp3.vo.Resource

class TvShowViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getTvShow(): LiveData<Resource<PagedList<TvShowEntity>>> = filmRepository.getTvShows()
}