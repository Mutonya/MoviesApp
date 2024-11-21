package com.maestro.moviesapp.data.remote

import com.maestro.moviesapp.utils.Resource
import retrofit2.Response

suspend fun<T> safeApiCall(
    apiCall: suspend () -> Response<T>

): Resource<T> {
    return try {
        val response = apiCall()
        if (response.isSuccessful) {
            response.body()?.let {
                Resource.Success(data = it)
            }?: Resource.Error(message = "Response body is null")
        } else {
            Resource.Error(message = response.message())
        }

    }catch (e:Exception){
        Resource.Error(message = e.message.toString())

    }
}