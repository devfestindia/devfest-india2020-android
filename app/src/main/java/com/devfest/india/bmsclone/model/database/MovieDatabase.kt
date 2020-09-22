package com.devfest.india.bmsclone.model.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.devfest.india.bmsclone.model.MovieResponse

@Database(
    entities = [MovieResponse::class],
    version = 1
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun mainMovieDao(): MovieDao

    //making Database singleton
    companion object {

        @Volatile
        private var instance: MovieDatabase? = null  // volatile
        private val LOCK = Any() //dummy object to make sure no 2 threads are doing the same task

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDB(context).also { instance = it }
        }

        private fun buildDB(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                MovieDatabase::class.java,
                "movie.db"
            ).build()


    }
}