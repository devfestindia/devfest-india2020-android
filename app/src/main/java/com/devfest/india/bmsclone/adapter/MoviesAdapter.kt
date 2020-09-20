package com.devfest.india.bmsclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devfest.india.bmsclone.R
import com.devfest.india.bmsclone.model.Movie

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

    override fun getItemCount(): Int {
        return movies.count()
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        return holder.bind(movies[position])
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val photo: ImageView = itemView.findViewById(R.id.movie_poster)
        private val title: TextView = itemView.findViewById(R.id.movie_title)
        private val releaseDate: TextView = itemView.findViewById(R.id.release_date)
        private val averageVoting: TextView = itemView.findViewById(R.id.avg_voting)
        private val totalVotes: TextView = itemView.findViewById(R.id.total_votes)

        companion object {
            private const val IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500"
        }

        fun bind(movie: Movie) {
            Glide.with(itemView.context).load(IMAGE_BASE_URL + movie.posterPath)
                .into(photo)
            title.text = movie.title
            releaseDate.text = movie.releaseDate
            averageVoting.text = movie.voteAverage.toString()
            totalVotes.text = movie.voteCount.toString()
        }
    }
}
