package com.timotiushaniel.bajp3.ui.home.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.timotiushaniel.bajp3.data.FilmRepository
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity
import com.timotiushaniel.bajp3.vo.Resource
import junit.framework.TestCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var filmRepository: FilmRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(filmRepository)
    }

    @Test
    fun getMovies() {
        val dummyTvShows = Resource.success(pagedList)
        Mockito.`when`(dummyTvShows.data?.size).thenReturn(5)
        val tvShows = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShows.value = dummyTvShows

        Mockito.`when`(filmRepository.getTvShows()).thenReturn(tvShows)
        val tvShowEntities = viewModel.getTvShow().value?.data
        verify(filmRepository).getTvShows()
        TestCase.assertNotNull(tvShowEntities)
        TestCase.assertEquals(5, tvShowEntities?.size)

        viewModel.getTvShow().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}