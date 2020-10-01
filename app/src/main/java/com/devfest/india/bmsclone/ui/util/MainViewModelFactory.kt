package com.devfest.india.bmsclone.ui.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devfest.india.bmsclone.data.MovieRepository
import com.devfest.india.bmsclone.ui.MainViewModel
import com.devfest.india.bmsclone.util.NetworkHelper

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val networkHelper: NetworkHelper,
    private val movieRepository: MovieRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(networkHelper, movieRepository) as T
    }
}
