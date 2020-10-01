package com.devfest.india.bmsclone.data

import com.devfest.india.bmsclone.data.local.database.dao.MovieDao
import com.devfest.india.bmsclone.data.local.database.entity.MovieResponse
import com.devfest.india.bmsclone.data.remote.retrofit.MovieService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieDao: MovieDao,
    private val movieService: MovieService
) : MovieRepository {

    override fun fetchMovies(
        apiKey: String,
        onSuccess: (MovieResponse) -> Unit,
        onError: (String) -> Unit
    ) {
        val response = movieService.getMovies(apiKey)
        response.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    Thread {
                        movieDao.insertMovies(response.body()!!)
                        onSuccess(response.body()!!)
                    }.start()
                } else {
                    onError(response.message())
                }
            }

            override fun onFailure(call: Call<MovieResponse>, throwable: Throwable) {
                onError(throwable.localizedMessage ?: "Something went wrong")
            }
        })
    }

    override fun getMoviesLocal(onSuccess: (MovieResponse?) -> Unit) {
        Thread {
            onSuccess(movieDao.getMovies())
        }.start()
    }

}