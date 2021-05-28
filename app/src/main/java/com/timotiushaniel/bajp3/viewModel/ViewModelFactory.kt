package com.timotiushaniel.bajp3.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.timotiushaniel.bajp3.data.FilmRepository
import com.timotiushaniel.bajp3.di.Injection
import com.timotiushaniel.bajp3.ui.detail.DetailViewModel
import com.timotiushaniel.bajp3.ui.favorite.movies.FavoriteMoviesViewModel
import com.timotiushaniel.bajp3.ui.favorite.tvshow.FavoriteTvShowViewModel
import com.timotiushaniel.bajp3.ui.home.movies.MoviesViewModel
import com.timotiushaniel.bajp3.ui.home.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val filmRepository: FilmRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(filmRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(filmRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(filmRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMoviesViewModel::class.java) -> {
                FavoriteMoviesViewModel(filmRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTvShowViewModel::class.java) -> {
                FavoriteTvShowViewModel(filmRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }
}