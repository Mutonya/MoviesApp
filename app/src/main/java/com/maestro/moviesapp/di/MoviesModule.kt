package com.maestro.moviesapp.di

import com.maestro.moviesapp.data.remote.MoviesApi
import com.maestro.moviesapp.data.repo.MoviesRepositoryImpl
import com.maestro.moviesapp.domain.repo.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviesModule {
    @Provides
    @Singleton
    fun providemoviesRepository(
        moviesApi: MoviesApi, coroutineDispatcher: CoroutineDispatcher
    ): MoviesRepository {
    return MoviesRepositoryImpl(moviesApi, coroutineDispatcher)
}
@Provides
@Singleton
fun provideCorutineDispatcher(): CoroutineDispatcher {
    return Dispatchers.IO
}
}