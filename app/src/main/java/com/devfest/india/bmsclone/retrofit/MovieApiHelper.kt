package com.mindorks.example.coroutines.data.api

import com.devfest.india.bmsclone.model.MovieResponse
import retrofit2.Call


interface MovieApiHelper {

     fun getMovies(apiKey:String): MovieResponse


}