package com.devfest.india.bmsclone.data.local.database

import com.devfest.india.bmsclone.data.local.database.dao.MovieDao
import com.devfest.india.bmsclone.data.local.database.entity.MovieResponse

class MovieRepositoryLocalImpl(private val movieDao: MovieDao) : MovieRepositoryLocal {

    override fun getMovies(onSuccess: (MovieResponse) -> Unit) {
        Thread {
            val movies: MovieResponse? = movieDao.getMovies()
            onSuccess(movies ?: MovieResponse(results = emptyList()))
        }.start()
    }

    override fun insertMovies(movieResponse: MovieResponse, onSuccess: () -> Unit) {
        Thread {
            movieDao.insertMovies(movieResponse)
            onSuccess()
        }.start()
    }

}