package com.timotiushaniel.bajp3.ui.favorite.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.timotiushaniel.bajp3.data.FilmRepository
import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity
import com.timotiushaniel.bajp3.utils.DataDummy
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMoviesViewModelTest {

    private lateinit var viewModel: FavoriteMoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var favoriteMoviesRepository: FilmRepository

    @Mock
    private lateinit var moviesObserver: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteMoviesViewModel(favoriteMoviesRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val dummyFavoriteMovie = pagedList
        `when`(dummyFavoriteMovie.size).thenReturn(5)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = dummyFavoriteMovie

        `when`(favoriteMoviesRepository.getFavoriteMovie()).thenReturn(movies)
        val movieEntities = viewModel.getFavoriteMovies().value
        verify(favoriteMoviesRepository).getFavoriteMovie()
        Assert.assertNotNull(movieEntities)
        Assert.assertEquals(5, movieEntities?.size)

        viewModel.getFavoriteMovies().observeForever(moviesObserver)
        verify(moviesObserver).onChanged(dummyFavoriteMovie)
    }

    @Test
    fun setFavoriteMovies() {
        viewModel.setFavoriteMovies(DataDummy.getMoviesDetail())
        verify(favoriteMoviesRepository).setFavoriteMovie(DataDummy.getMoviesDetail(), true)
        verifyNoMoreInteractions(favoriteMoviesRepository)
    }
}