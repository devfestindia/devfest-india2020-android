package com.devfest.india.bmsclone.data.remote.retrofit

import com.devfest.india.bmsclone.data.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Niharika.Arora
 */
interface MovieService {
    @GET("discover/movie")
    fun getMovies(@Query("api_key") key: String): Response<MovieResponse>
}