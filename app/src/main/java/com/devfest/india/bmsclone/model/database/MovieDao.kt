package com.devfest.india.bmsclone.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devfest.india.bmsclone.model.MovieResponse

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(movieResponse: MovieResponse)

    @Query("Select * from tbl_movie_data")
    fun getMovies(): LiveData<MovieResponse>
}