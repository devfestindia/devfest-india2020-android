package com.devfest.india.bmsclone.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devfest.india.bmsclone.data.local.database.MovieRepositoryLocal
import com.devfest.india.bmsclone.data.local.database.entity.MovieResponse
import com.devfest.india.bmsclone.data.remote.retrofit.MovieRepositoryRemote
import com.devfest.india.bmsclone.util.NetworkHelper


class MainViewModel(
    private val networkHelper: NetworkHelper,
    private val movieRepositoryLocal: MovieRepositoryLocal,
    private val movieRepositoryRemote: MovieRepositoryRemote
) : ViewModel() {

    companion object {

        private const val API_KEY = "7bc0651fe0ea5973822df3bd27e779d9"
        private const val NO_INTERNET_CONNECTION = "No internet connection"

    }

    private val _moviesResponse = MutableLiveData<MovieResponse>()
    val movieResponse: LiveData<MovieResponse>
        get() = _moviesResponse

    private val _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String>
        get() = _errorResponse

    fun getMovies() {
        movieRepositoryLocal.getMovies { movieResponse ->
            if (movieResponse.results.isNotEmpty()) {
                _moviesResponse.postValue(movieResponse)
            } else {
                getMoviesFromRemote()
            }
        }
    }

    private fun getMoviesFromRemote() {
        if (networkHelper.isNetworkConnected()) {
            movieRepositoryRemote.getMovies(API_KEY, { movieResponse ->
                movieRepositoryLocal.insertMovies(movieResponse) {
                    _moviesResponse.postValue(movieResponse)
                }
            }, { error ->
                _errorResponse.postValue(error)
            })
        } else {
            _errorResponse.postValue(NO_INTERNET_CONNECTION)
        }

    }
}