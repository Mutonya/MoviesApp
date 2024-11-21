package com.maestro.moviesapp.data.repo

import com.maestro.moviesapp.data.models.MoviesResultResponse
import com.maestro.moviesapp.data.remote.MoviesApi
import com.maestro.moviesapp.data.remote.safeApiCall
import com.maestro.moviesapp.domain.repo.MoviesRepository
import com.maestro.moviesapp.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
): MoviesRepository {
    override suspend fun getPopularMovies(page: Int): Resource<MoviesResultResponse> {
        return try {
            withContext(coroutineDispatcher){
                val response = safeApiCall { moviesApi.getPopularMovies(page = page) }

                when(response){
                    is Resource.Error -> Resource.Error(message = response.message)
                    is Resource.Loading -> Resource.Loading()
                    is Resource.Success -> Resource.Success(data = response.data)
                }
            }




        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }

    override suspend fun getUpComingMovies(page: Int): Resource<MoviesResultResponse> {
        return try {
            withContext(coroutineDispatcher){
                val response = safeApiCall { moviesApi.getUpComingMovies(page = page) }

                when(response){
                    is Resource.Error -> Resource.Error(message = response.message)
                    is Resource.Loading -> Resource.Loading()
                    is Resource.Success -> Resource.Success(data = response.data)
                }
            }




        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }

    override suspend fun getTopRatedMovies(page: Int): Resource<MoviesResultResponse> {
        return try {
            withContext(coroutineDispatcher){
                val response = safeApiCall { moviesApi.getTopRatedMovies(page = page) }

                when(response){
                    is Resource.Error -> Resource.Error(message = response.message)
                    is Resource.Loading -> Resource.Loading()
                    is Resource.Success -> Resource.Success(data = response.data)
                }
            }




        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }

    override suspend fun getNowPlayingMovies(page: Int): Resource<MoviesResultResponse> {
        return try {
            withContext(coroutineDispatcher){
                val response = safeApiCall { moviesApi.getNowPlayingMovies(page = page) }

                when(response){
                    is Resource.Error -> Resource.Error(message = response.message)
                    is Resource.Loading -> Resource.Loading()
                    is Resource.Success -> Resource.Success(data = response.data)
                }
            }




        }catch (e:Exception){
            Resource.Error(message = e.message.toString())
        }
    }
}