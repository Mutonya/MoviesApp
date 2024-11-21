package com.maestro.moviesapp.data.remote

import com.maestro.moviesapp.data.models.MoviesResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ): Response<MoviesResultResponse>

    @GET("movie/upcoming")
    suspend fun getUpComingMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ):  Response<MoviesResultResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ):  Response<MoviesResultResponse>

    @GET("movie/now_playing")
    suspend  fun getNowPlayingMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int
    ):  Response<MoviesResultResponse>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("language") language: String = "en-US"
    ):  Response<MoviesResultResponse>

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCredits(
        @Path("movie_id") movieId: String,
        @Query("language") language: String = "en-US"
    ):  Response<MoviesResultResponse>
    @GET("movie/{movie_id}/reviews")
    suspend fun getMovieReviews(
        @Path("movie_id") movieId: String,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1
    ):  Response<MoviesResultResponse>

    @GET("movie/{id}/videos")
    suspend fun getMovieVideos(@Path("id") movieId: Int):  Response<MoviesResultResponse>
}