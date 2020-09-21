package com.devfest.india.bmsclone.model

/**
 * @author Niharika.Arora
 */
data class Movie(
    val id: Int,
    val posterPath: String,
    val releaseDate: String,
    val title: String,
    val voteAverage: Double,
    val voteCount: Int
)