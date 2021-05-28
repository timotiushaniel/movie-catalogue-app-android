package com.timotiushaniel.bajp3.di

import android.content.Context
import com.timotiushaniel.bajp3.data.FilmRepository
import com.timotiushaniel.bajp3.data.source.local.LocalDataSource
import com.timotiushaniel.bajp3.data.source.local.room.FilmDatabase
import com.timotiushaniel.bajp3.data.source.remote.RemoteDataSource
import com.timotiushaniel.bajp3.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): FilmRepository {

        val database = FilmDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.filmDao())
        val appExecutors = AppExecutors()

        return FilmRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}