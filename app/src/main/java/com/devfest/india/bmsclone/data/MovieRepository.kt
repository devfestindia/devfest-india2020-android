package com.devfest.india.bmsclone.data

import androidx.lifecycle.LiveData
import com.devfest.india.bmsclone.data.local.database.entity.MovieResponse

interface MovieRepository {

    fun fetchMovies(apiKey: String, onError: (String) -> Unit)

    fun getMovies(): LiveData<MovieResponse>

    fun insertMovies(movieResponse: MovieResponse, onSuccess: () -> Unit)
}