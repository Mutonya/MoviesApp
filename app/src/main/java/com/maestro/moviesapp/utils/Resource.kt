package com.maestro.moviesapp.utils

sealed class Resource<D> {
    data class Success<D>(val data: D, val message: String? = null) : Resource<D>()
    data class Error<D>(val data: D? = null,val message: String) : Resource<D>()
    data class Loading<D>(val data: D? = null) : Resource<D>()

}