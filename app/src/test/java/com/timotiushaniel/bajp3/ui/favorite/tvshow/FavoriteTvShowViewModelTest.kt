package com.timotiushaniel.bajp3.ui.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.timotiushaniel.bajp3.data.FilmRepository
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity
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
class FavoriteTvShowViewModelTest {

    private lateinit var viewModel: FavoriteTvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var favoriteTvShowRepository: FilmRepository

    @Mock
    private lateinit var tvShowObserver: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteTvShowViewModel(favoriteTvShowRepository)
    }

    @Test
    fun getFavoriteTvShows() {
        val dummyFavoriteTvShow = pagedList
        `when`(dummyFavoriteTvShow.size).thenReturn(5)
        val tvShows = MutableLiveData<PagedList<TvShowEntity>>()
        tvShows.value = dummyFavoriteTvShow

        `when`(favoriteTvShowRepository.getFavoriteTvShow()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getFavoriteTvShows().value
        verify(favoriteTvShowRepository).getFavoriteTvShow()
        Assert.assertNotNull(tvShowEntities)
        Assert.assertEquals(5, tvShowEntities?.size)

        viewModel.getFavoriteTvShows().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyFavoriteTvShow)
    }

    @Test
    fun setFavoriteTvShows() {
        viewModel.setFavoriteTvShows(DataDummy.getTvShowsDetail())
        verify(favoriteTvShowRepository).setFavoriteTvShow(DataDummy.getTvShowsDetail(), true)
        verifyNoMoreInteractions(favoriteTvShowRepository)
    }
}