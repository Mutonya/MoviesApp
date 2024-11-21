package com.maestro.moviesapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.maestro.moviesapp.databinding.HomefragmentBinding
import com.maestro.moviesapp.ui.vm.MoviesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment :Fragment() {
    private val viewModel: MoviesViewModel by viewModels()
    val TAG = "HomeFragment"
    private var _binding: HomefragmentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomefragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeHomeUiState()

    }

    private fun observeHomeUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.homeUistate.collect { homeUiState ->
                    if (homeUiState.isLoading) {
                        //show a loading state
                    } else {
                        val data = homeUiState.popularMovies
                        Log.d(TAG, "observeHomeUiState: $data")
                    }
                }
            }
        }
    }
}