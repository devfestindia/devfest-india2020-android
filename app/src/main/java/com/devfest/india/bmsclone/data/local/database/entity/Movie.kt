package com.devfest.india.bmsclone.data.local.database.entity

import com.google.gson.annotations.SerializedName

/**
 * @author Niharika.Arora
 */
data class Movie(
    val id: Int,

    @SerializedName("poster_path")
    val posterPath: String,

    @SerializedName("release_date")
    val releaseDate: String,

    val title: String,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Int
)