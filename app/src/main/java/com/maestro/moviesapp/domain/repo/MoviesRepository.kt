package com.maestro.moviesapp.domain.repo

import com.maestro.moviesapp.data.models.MoviesResultResponse
import com.maestro.moviesapp.utils.Resource

interface MoviesRepository {

    suspend fun getPopularMovies(page: Int): Resource<MoviesResultResponse>
    suspend fun getUpComingMovies(page: Int): Resource<MoviesResultResponse>
    suspend fun getTopRatedMovies(page: Int): Resource<MoviesResultResponse>
    suspend fun getNowPlayingMovies(page: Int): Resource<MoviesResultResponse>



}