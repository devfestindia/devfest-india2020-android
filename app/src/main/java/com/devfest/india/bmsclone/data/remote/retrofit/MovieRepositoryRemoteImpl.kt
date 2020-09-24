package com.devfest.india.bmsclone.data.remote.retrofit

import com.devfest.india.bmsclone.data.local.database.entity.MovieResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepositoryRemoteImpl(private val apiService: MovieService) : MovieRepositoryRemote {

    override fun getMovies(
        apiKey: String,
        onSuccess: (MovieResponse) -> Unit,
        onError: (String) -> Unit
    ) {
        val response = apiService.getMovies(apiKey)
        response.enqueue(object :Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful) {
                    onSuccess(response.body()!!)
                } else {
                    onError(response.message())
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                onError(t.localizedMessage)
            }
        })

    }
}