package com.timotiushaniel.bajp3.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.timotiushaniel.bajp3.data.FilmRepository
import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity
import com.timotiushaniel.bajp3.utils.DataDummy
import com.timotiushaniel.bajp3.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel

    private val dummyMovies = DataDummy.getMoviesDetail()
    private val moviesId = dummyMovies.id

    private val dummyTvShow = DataDummy.getTvShowsDetail()
    private val tvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var movieDetailObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowsDetailObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(filmRepository)
        if (moviesId != null) {
            viewModel.setSelectedMovies(moviesId)
        }
        if (tvShowId != null) {
            viewModel.setSelectedTvShow(tvShowId)
        }
    }

    @Test
    fun getMoviesDetail() {
        val expected = MutableLiveData<Resource<MovieEntity>>()
        expected.value = Resource.success(DataDummy.getMoviesDetail())

        `when`(moviesId?.let { filmRepository.getDetailMovies(it) }).thenReturn(expected)
        if (moviesId != null) {
            viewModel.setSelectedMovies(moviesId)
        }
        viewModel.getMoviesDetail().observeForever(movieDetailObserver)
        verify(movieDetailObserver).onChanged(expected.value)
    }

    @Test
    fun getTvShowDetail() {
        val expected = MutableLiveData<Resource<TvShowEntity>>()
        expected.value = Resource.success(DataDummy.getTvShowsDetail())

        `when`(tvShowId?.let { filmRepository.getDetailTVShows(it) }).thenReturn(expected)
        if (tvShowId != null) {
            viewModel.setSelectedTvShow(tvShowId)
        }
        viewModel.getTvShowDetail().observeForever(tvShowsDetailObserver)
        verify(tvShowsDetailObserver).onChanged(expected.value)
    }

    @Test
    fun setFavoriteMovie() {
        val expected = MutableLiveData<Resource<MovieEntity>>()
        expected.value = Resource.success(DataDummy.getMoviesDetail())

        `when`(moviesId?.let { filmRepository.getDetailMovies(it) }).thenReturn(expected)
        if (moviesId != null) {
            viewModel.setSelectedMovies(moviesId)
        }
        viewModel.setFavoriteMovie()
        verify(filmRepository).setFavoriteMovie(expected.value!!.data as MovieEntity, true)
        verifyNoMoreInteractions(movieDetailObserver)
    }

    @Test
    fun setFavoriteTvShow() {
        val expected = MutableLiveData<Resource<TvShowEntity>>()
        expected.value = Resource.success(DataDummy.getTvShowsDetail())

        `when`(tvShowId?.let { filmRepository.getDetailTVShows(it) }).thenReturn(expected)
        if (tvShowId != null) {
            viewModel.setSelectedTvShow(tvShowId)
        }
        viewModel.setFavoriteTvShow()
        verify(filmRepository).setFavoriteTvShow(expected.value!!.data as TvShowEntity, true)
        verifyNoMoreInteractions(tvShowsDetailObserver)
    }
}