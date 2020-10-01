package com.devfest.india.bmsclone.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devfest.india.bmsclone.R
import com.devfest.india.bmsclone.data.local.database.entity.Movie
import kotlinx.android.synthetic.main.movie_item_layout.view.*

/**
 * @author Niharika.Arora
 */
class MoviesAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun getItemCount(): Int = movies.count()

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) =
        holder.bind(movies[position])

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        companion object {
            private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"
        }

        fun bind(movie: Movie) {
            Glide.with(itemView.context).load(IMAGE_BASE_URL + movie.posterPath)
                .into(itemView.moviePoster)
            itemView.movieTitle.text = movie.title
            itemView.releaseDate.text = movie.releaseDate
            itemView.avgVoting.text = movie.voteAverage.toString()
            itemView.totalVotes.text = movie.voteCount.toString()
        }
    }
}
