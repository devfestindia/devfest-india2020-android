package com.devfest.india.bmsclone.data.local.database

import com.devfest.india.bmsclone.data.MovieResponse

interface MovieRepositoryLocal {

    fun getMovies(apiKey: String, onSuccess: (MovieResponse) -> Unit)

    fun insertMovies(movieResponse: MovieResponse, onSuccess: () -> Unit)
}