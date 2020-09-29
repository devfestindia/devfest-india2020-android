package com.devfest.india.bmsclone.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devfest.india.bmsclone.data.local.database.entity.MovieResponse

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movieResponse: MovieResponse)

    @Query("select * from tbl_movie_data")
    fun getMovies(): MovieResponse

}