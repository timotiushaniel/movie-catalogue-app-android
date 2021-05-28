package com.timotiushaniel.bajp3.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.timotiushaniel.bajp3.data.FakeFilmRepository
import com.timotiushaniel.bajp3.data.source.local.LocalDataSource
import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity
import com.timotiushaniel.bajp3.data.source.remote.RemoteDataSource
import com.timotiushaniel.bajp3.utils.AppExecutors
import com.timotiushaniel.bajp3.utils.DataDummy
import com.timotiushaniel.bajp3.utils.LiveDataTestUtil
import com.timotiushaniel.bajp3.utils.PagedListUtil
import com.timotiushaniel.bajp3.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class FilmRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val filmRepository = FakeFilmRepository(remote, local, appExecutors)

    private val moviesResponse = DataDummy.getRemoteMovies()
    private val movieId = moviesResponse[0].id
    private val movieDetail = DataDummy.getRemoteMoviesDetail()

    private val tvShowsResponse = DataDummy.getRemoteTvShows()
    private val tvShowId = tvShowsResponse[0].id
    private val tvShowDetail = DataDummy.getRemoteTvShowsDetail()

    @Test
    fun getMovies() {
        val dataSourceMoviesFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovies()).thenReturn(dataSourceMoviesFactory)
        filmRepository.getMovies()

        val moviesEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.getMovies()))
        verify(local).getMovies()
        assertNotNull(moviesEntities)
        assertEquals(moviesResponse.size, moviesEntities.data?.size)
    }

    @Test
    fun getTvShows() {
        val dataSourceTvShowFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShows()).thenReturn(dataSourceTvShowFactory)
        filmRepository.getTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.getTvShows()))
        verify(local).getTvShows()
        assertNotNull(tvShowEntities.data)
        assertEquals(tvShowsResponse.size.toLong(), tvShowEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovies() {
        val dummyDetailMovies = MutableLiveData<MovieEntity>()
        dummyDetailMovies.value = DataDummy.getMoviesDetail()
        `when`(local.getMovieById(movieId)).thenReturn(dummyDetailMovies)

        val moviesDetailEntities =
            LiveDataTestUtil.getValue(filmRepository.getDetailMovies(movieId))
        verify(local).getMovieById(movieId)
        assertNotNull(moviesDetailEntities.data)
        assertEquals(movieDetail.id, moviesDetailEntities.data?.id)
    }

    @Test
    fun getDetailTVShows() {
        val dummyDetailTvShow = MutableLiveData<TvShowEntity>()
        dummyDetailTvShow.value = DataDummy.getTvShowsDetail()
        `when`(local.getTvShowById(tvShowId)).thenReturn(dummyDetailTvShow)

        val tvShowDetailEntities =
            LiveDataTestUtil.getValue(filmRepository.getDetailTVShows(tvShowId))
        verify(local).getTvShowById(tvShowId)
        assertNotNull(tvShowDetailEntities.data)
        assertEquals(tvShowDetail.id, tvShowDetailEntities.data?.id)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceMoviesFavoriteFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceMoviesFavoriteFactory)
        filmRepository.getFavoriteMovie()

        val moviesFavoriteEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.getMovies()))
        verify(local).getFavoriteMovie()
        assertNotNull(moviesFavoriteEntities.data)
        assertEquals(moviesResponse.size.toLong(), moviesFavoriteEntities.data?.size?.toLong())
    }

    @Test
    fun getFavoriteTvShow() {
        val dataSourceTvShowFavoriteFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShow()).thenReturn(dataSourceTvShowFavoriteFactory)
        filmRepository.getFavoriteTvShow()

        val tvShowFavoriteEntities =
            Resource.success(PagedListUtil.mockPagedList(DataDummy.getTvShows()))
        verify(local).getFavoriteTvShow()
        assertNotNull(tvShowFavoriteEntities.data)
        assertEquals(tvShowsResponse.size.toLong(), tvShowFavoriteEntities.data?.size?.toLong())
    }

    @Test
    fun setFavoriteMovie() {
        filmRepository.setFavoriteMovie(DataDummy.getMoviesDetail(), true)
        verify(local).setFavoriteMovie(DataDummy.getMoviesDetail(), true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun setFavoriteTvShow() {
        filmRepository.setFavoriteTvShow(DataDummy.getTvShowsDetail(), true)
        verify(local).setFavoriteTvShow(DataDummy.getTvShowsDetail(), true)
        verifyNoMoreInteractions(local)
    }
}