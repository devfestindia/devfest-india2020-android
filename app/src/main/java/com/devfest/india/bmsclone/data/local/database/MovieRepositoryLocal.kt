package com.devfest.india.bmsclone.data.local.database

import com.devfest.india.bmsclone.data.local.database.entity.MovieResponse

interface MovieRepositoryLocal {

    fun getMovies(onSuccess: (MovieResponse) -> Unit)

    fun insertMovies(movieResponse: MovieResponse, onSuccess: () -> Unit)
}