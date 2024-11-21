package com.maestro.moviesapp.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maestro.moviesapp.domain.repo.MoviesRepository
import com.maestro.moviesapp.ui.states.HomeUistate
import com.maestro.moviesapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel@Inject constructor(
    private val moviesRepository: MoviesRepository
):ViewModel() {

    //states in StateFlow

    private val _homeUistate  = MutableStateFlow(HomeUistate())
    val homeUistate: StateFlow<HomeUistate> = _homeUistate.asStateFlow()


    init {

        getPopularMovies()
    }

    fun getPopularMovies(){
        _homeUistate.value = _homeUistate.value.copy(isLoading = true)
        viewModelScope.launch {

            val result = moviesRepository.getPopularMovies(1)
            when(result){
                is Resource.Error -> _homeUistate.value = _homeUistate.value.copy(isLoading = false, error = result.message)
                is Resource.Loading -> _homeUistate.value = _homeUistate.value.copy(isLoading = true)
                is Resource.Success -> _homeUistate.value = _homeUistate.value.copy(popularMovies = result.data.results, isLoading = false)
            }

        }
    }


}