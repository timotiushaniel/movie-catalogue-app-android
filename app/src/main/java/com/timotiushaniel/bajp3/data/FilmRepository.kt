package com.timotiushaniel.bajp3.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.timotiushaniel.bajp3.data.source.local.LocalDataSource
import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity
import com.timotiushaniel.bajp3.data.source.model.FilmResult
import com.timotiushaniel.bajp3.data.source.remote.ApiResponse
import com.timotiushaniel.bajp3.data.source.remote.RemoteDataSource
import com.timotiushaniel.bajp3.data.source.remote.response.DetailFilmResponse
import com.timotiushaniel.bajp3.utils.AppExecutors
import com.timotiushaniel.bajp3.vo.Resource
import timber.log.Timber

class FilmRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    ItemDataSource {

    override fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<FilmResult>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<FilmResult>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<FilmResult>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        response.id,
                        response.title,
                        response.overview,
                        response.voteAverage,
                        false,
                        response.genreIds.toString(),
                        response.releaseDate,
                        response.backdropPath,
                        response.posterPath
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<FilmResult>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<FilmResult>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(data: List<FilmResult>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(
                        response.id,
                        response.title,
                        response.overview,
                        response.voteAverage,
                        false,
                        response.genreIds.toString(),
                        response.releaseDate,
                        response.backdropPath,
                        response.posterPath
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShow(tvShowList)
            }
        }.asLiveData()
    }

    override fun getDetailMovies(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object :
            NetworkBoundResource<MovieEntity, DetailFilmResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> = localDataSource.getMovieById(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<DetailFilmResponse>> =
                remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(data: DetailFilmResponse) {
                val genresList = ArrayList<String>()
                for (genre in data.genres!!) {
                    genre.name?.let { genresList.add(it) }
                }
                Timber.d("genreList: $genresList")
                val detailData = MovieEntity(
                    data.id,
                    data.title,
                    data.overview,
                    data.voteAverage,
                    false,
                    genresList.toString(),
                    data.releaseDate,
                    data.backdropPath,
                    data.posterPath,
                )
                localDataSource.updateMovie(detailData, false)
            }
        }.asLiveData()
    }

    override fun getDetailTVShows(tvId: Int): LiveData<Resource<TvShowEntity>> {
        return object :
            NetworkBoundResource<TvShowEntity, DetailFilmResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> = localDataSource.getTvShowById(tvId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<DetailFilmResponse>> =
                remoteDataSource.getDetailTvShow(tvId)

            override fun saveCallResult(data: DetailFilmResponse) {
                val genresList = ArrayList<String>()
                for (genre in data.genres!!) {
                    genre.name?.let { genresList.add(it) }
                }
                val detailData = TvShowEntity(
                    data.id,
                    data.title,
                    data.overview,
                    data.voteAverage,
                    false,
                    genresList.toString(),
                    data.releaseDate,
                    data.backdropPath,
                    data.posterPath,
                )
                localDataSource.updateTvShow(detailData, false)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun getFavoriteTvShow(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }

    override fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean) =
        appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShow, state) }

    companion object {
        @Volatile
        private var instance: FilmRepository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): FilmRepository =
            instance ?: synchronized(this) {
                instance ?: FilmRepository(remoteData, localData, appExecutors).apply {
                    instance = this
                }
            }
    }
}