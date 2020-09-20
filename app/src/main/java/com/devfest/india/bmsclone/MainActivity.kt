package com.devfest.india.bmsclone

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.devfest.india.bmsclone.adapter.MoviesAdapter
import com.devfest.india.bmsclone.model.Movie
import com.devfest.india.bmsclone.model.MovieResponse
import com.devfest.india.bmsclone.retrofit.MovieService
import com.devfest.india.bmsclone.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var errorView: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Bind views
        bindViews()
        //Fetch List of Movies
        fetchMovies()
    }

    private fun bindViews() {
        progressBar = findViewById(R.id.progress_bar)
        recyclerView = findViewById(R.id.recycler_view)
        errorView = findViewById(R.id.error_view)
    }

    private fun fetchMovies() {
        showProgress()

        val request = RetrofitBuilder.buildService(MovieService::class.java)
        val call = request.getMovies(getString(R.string.api_key))

        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                hideProgress()
                if (response.isSuccessful && response.body() != null) {
                    showMovies(response.body()!!.results)
                } else {
                    showErrorMessage(getString(R.string.error_msg))
                }
            }

            override fun onFailure(call: Call<MovieResponse>, throwable: Throwable) {
                hideProgress()
                showErrorMessage(throwable.message)
            }
        })
    }

    private fun showMovies(movies: List<Movie>) {
        recyclerView.visibility = View.VISIBLE
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = MoviesAdapter(movies)
    }

    private fun showErrorMessage(errorMessage: String?) {
        errorView.visibility = View.VISIBLE
        errorView.text = errorMessage
    }

    private fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    private fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }
}