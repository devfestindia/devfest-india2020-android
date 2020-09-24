package com.devfest.india.bmsclone.data.local.database

import com.devfest.india.bmsclone.data.MovieResponse
import com.devfest.india.bmsclone.data.local.database.dao.MovieDao

class MovieRepositoryLocalImpl(private val movieDao: MovieDao) : MovieRepositoryLocal {

    override fun getMovies(apiKey: String, onSuccess: (MovieResponse) -> Unit) {
        Thread {
            val movies = movieDao.getMovies()
            onSuccess(movies)
        }.start()
    }

    override fun insertMovies(movieResponse: MovieResponse, onSuccess: () -> Unit) {
        Thread {
            movieDao.insertOrUpdate(movieResponse)
            onSuccess()
        }.start()
    }

}