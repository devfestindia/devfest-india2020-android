package com.devfest.india.bmsclone.data

import com.devfest.india.bmsclone.data.local.database.entity.MovieResponse

interface MovieRepository {

    fun fetchMovies(apiKey: String, onSuccess: (MovieResponse) -> Unit, onError: (String) -> Unit)

    fun getMoviesLocal(onSuccess: (MovieResponse?) -> Unit)
}