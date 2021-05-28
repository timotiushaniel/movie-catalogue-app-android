package com.timotiushaniel.bajp3.ui.home.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.timotiushaniel.bajp3.data.FilmRepository
import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity
import com.timotiushaniel.bajp3.vo.Resource

class MoviesViewModel(private val filmRepository: FilmRepository) : ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> = filmRepository.getMovies()
}