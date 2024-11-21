package com.maestro.moviesapp.ui.states

data class HomeUistate(
    var popularMovies: List<com.maestro.moviesapp.data.models.Result> = emptyList(),
    var upComingMovies: List<com.maestro.moviesapp.data.models.Result> = emptyList(),
    var topRatedMovies: List<com.maestro.moviesapp.data.models.Result> = emptyList(),
    var nowPlayingMovies: List<com.maestro.moviesapp.data.models.Result> = emptyList(),
    var isLoading: Boolean = false,
    var error: String? = null,
    var isRefreshing: Boolean = false,
    var isError: Boolean = false
)
