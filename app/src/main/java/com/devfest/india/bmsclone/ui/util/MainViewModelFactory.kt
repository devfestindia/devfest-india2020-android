package com.devfest.india.bmsclone.ui.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devfest.india.bmsclone.data.local.database.MovieRepositoryLocal
import com.devfest.india.bmsclone.data.remote.retrofit.MovieRepositoryRemote
import com.devfest.india.bmsclone.ui.MainViewModel
import com.devfest.india.bmsclone.util.NetworkHelper

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val networkHelper: NetworkHelper,
    private val movieRepositoryLocal: MovieRepositoryLocal,
    private val movieRepositoryRemote: MovieRepositoryRemote
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(networkHelper, movieRepositoryLocal, movieRepositoryRemote) as T
    }
}
