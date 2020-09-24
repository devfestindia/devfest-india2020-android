package com.devfest.india.bmsclone.ui

import androidx.lifecycle.ViewModel
import com.devfest.india.bmsclone.data.local.database.MovieRepositoryLocal
import com.devfest.india.bmsclone.data.remote.retrofit.MovieRepositoryRemote
import com.devfest.india.bmsclone.util.NetworkHelper


class MainViewModel(
    private val networkHelper: NetworkHelper,
    private val movieRepositoryLocal: MovieRepositoryLocal,
    private val movieRepositoryRemote: MovieRepositoryRemote
) : ViewModel() {

}