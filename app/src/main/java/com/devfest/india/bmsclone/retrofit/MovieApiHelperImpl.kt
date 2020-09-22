package com.mindorks.example.coroutines.data.api

import com.devfest.india.bmsclone.model.MovieResponse
import com.devfest.india.bmsclone.retrofit.MovieService
import retrofit2.Call

class MovieApiHelperImpl(private val apiService: MovieService) : MovieApiHelper {

    override  fun getMovies(apiKey:String): MovieResponse = apiService.getMovies(apiKey)


}