package com.devfest.india.bmsclone.data.remote.retrofit

import com.devfest.india.bmsclone.data.MovieResponse

interface MovieRepositoryRemote {

    fun getMovies(apiKey: String, onSuccess: (MovieResponse) -> Unit)

}