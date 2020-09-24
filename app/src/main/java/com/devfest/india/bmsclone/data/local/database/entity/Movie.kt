package com.devfest.india.bmsclone.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * @author Niharika.Arora
 */
@Entity(tableName = "tbl_movie_data")
data class Movie(
    @PrimaryKey
    val id: Int,

    @SerializedName("poster_path")
    @ColumnInfo(name = "poster_path")
    val posterPath: String,

    @SerializedName("release_date")
    @ColumnInfo(name = "release_date")
    val releaseDate: String,

    @ColumnInfo(name = "title")
    val title: String,

    @SerializedName("vote_average")
    @ColumnInfo(name = "vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    @ColumnInfo(name = "vote_count")
    val voteCount: Int
)