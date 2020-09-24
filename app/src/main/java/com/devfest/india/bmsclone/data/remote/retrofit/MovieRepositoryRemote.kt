package com.devfest.india.bmsclone.data.remote.retrofit

import com.devfest.india.bmsclone.data.local.database.entity.MovieResponse

interface MovieRepositoryRemote {

    fun getMovies(apiKey: String, onSuccess: (MovieResponse) -> Unit, onError:(String)->Unit)

}