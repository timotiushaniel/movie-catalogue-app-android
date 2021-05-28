package com.timotiushaniel.bajp3.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.timotiushaniel.bajp3.data.source.model.FilmResult
import com.timotiushaniel.bajp3.data.source.remote.response.DetailFilmResponse
import com.timotiushaniel.bajp3.data.source.remote.response.FilmResponse
import com.timotiushaniel.bajp3.network.ApiConfig
import com.timotiushaniel.bajp3.utils.EspressoIdlingResource
import com.timotiushaniel.bajp3.utils.NetworkInfo.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class RemoteDataSource {

    fun getMovies(): LiveData<ApiResponse<List<FilmResult>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<FilmResult>>>()
        val client = ApiConfig.getApiService().getMovies(API_KEY)

        client.enqueue(object : Callback<FilmResponse> {
            override fun onResponse(
                call: Call<FilmResponse>,
                response: Response<FilmResponse>
            ) {
                if (response.isSuccessful) {
                    resultMovies.value =
                        ApiResponse.success(response.body()?.results as List<FilmResult>)
                    EspressoIdlingResource.decrement()
                } else {
                    Timber.d("RemoteDataSource getMovies onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<FilmResponse>, t: Throwable) {
                Timber.d("RemoteDataSource getMovies onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
        return resultMovies
    }

    fun getDetailMovie(movieId: Int): LiveData<ApiResponse<DetailFilmResponse>> {
        EspressoIdlingResource.increment()
        val resultDetailMovie = MutableLiveData<ApiResponse<DetailFilmResponse>>()
        val client = ApiConfig.getApiService().getMovieDetail(movieId, API_KEY)
        client.enqueue(object : Callback<DetailFilmResponse> {
            override fun onResponse(
                call: Call<DetailFilmResponse>,
                response: Response<DetailFilmResponse>
            ) {
                if (response.isSuccessful) {
                    resultDetailMovie.value =
                        ApiResponse.success(response.body() as DetailFilmResponse)
                    EspressoIdlingResource.decrement()
                } else {
                    Timber.d("RemoteDataSource getMovieDetail onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DetailFilmResponse>, t: Throwable) {
                Timber.d("RemoteDataSource getMovieDetail onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
        return resultDetailMovie
    }

    fun getTvShows(): LiveData<ApiResponse<List<FilmResult>>> {
        EspressoIdlingResource.increment()
        val resultTvShow = MutableLiveData<ApiResponse<List<FilmResult>>>()
        val client = ApiConfig.getApiService().getTvShows(API_KEY)
        client.enqueue(object : Callback<FilmResponse> {
            override fun onResponse(
                call: Call<FilmResponse>,
                response: Response<FilmResponse>
            ) {
                if (response.isSuccessful) {
                    resultTvShow.value =
                        ApiResponse.success(response.body()?.results as List<FilmResult>)
                    EspressoIdlingResource.decrement()
                } else {
                    Timber.d("RemoteDataSource getTvShows onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<FilmResponse>, t: Throwable) {
                Timber.d("RemoteDataSource getTvShows onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
        return resultTvShow
    }

    fun getDetailTvShow(tvShowId: Int): LiveData<ApiResponse<DetailFilmResponse>> {
        EspressoIdlingResource.increment()
        val resultDetailTvShow = MutableLiveData<ApiResponse<DetailFilmResponse>>()
        val client = ApiConfig.getApiService().getTvShowDetail(tvShowId, API_KEY)
        client.enqueue(object : Callback<DetailFilmResponse> {
            override fun onResponse(
                call: Call<DetailFilmResponse>,
                response: Response<DetailFilmResponse>
            ) {
                if (response.isSuccessful) {
                    resultDetailTvShow.value =
                        ApiResponse.success(response.body() as DetailFilmResponse)
                    EspressoIdlingResource.decrement()
                } else {
                    Timber.d("RemoteDataSource getDetailTvShow onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DetailFilmResponse>, t: Throwable) {
                Timber.d("RemoteDataSource getDetailTvShow onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
        return resultDetailTvShow
    }

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }
}