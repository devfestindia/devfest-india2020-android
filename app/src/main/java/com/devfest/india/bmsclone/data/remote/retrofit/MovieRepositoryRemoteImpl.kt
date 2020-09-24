package com.devfest.india.bmsclone.data.remote.retrofit

import com.devfest.india.bmsclone.data.MovieResponse

class MovieRepositoryRemoteImpl(private val apiService: MovieService) : MovieRepositoryRemote {

    override fun getMovies(apiKey: String, onSuccess: (MovieResponse) -> Unit) {
        val movieResponse = apiService.getMovies(apiKey).body() ?: MovieResponse(emptyList())
        onSuccess(movieResponse)
    }

}