package com.devfest.india.bmsclone.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import com.devfest.india.bmsclone.R
import com.devfest.india.bmsclone.data.MovieResponse
import com.devfest.india.bmsclone.data.local.database.MovieDatabase
import com.devfest.india.bmsclone.data.local.database.MovieRepositoryLocalImpl
import com.devfest.india.bmsclone.data.local.database.entity.Movie
import com.devfest.india.bmsclone.data.remote.retrofit.MovieRepositoryRemoteImpl
import com.devfest.india.bmsclone.data.remote.retrofit.MovieService
import com.devfest.india.bmsclone.data.remote.retrofit.RetrofitBuilder
import com.devfest.india.bmsclone.ui.adapter.MoviesAdapter
import com.devfest.india.bmsclone.ui.util.ViewModelFactory
import com.devfest.india.bmsclone.util.NetworkHelper
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this, ViewModelFactory(
                NetworkHelper(this),
                MovieRepositoryLocalImpl(MovieDatabase.getInstance(this).movieDao()),
                MovieRepositoryRemoteImpl(RetrofitBuilder.buildService(MovieService::class.java))
            )
        )[MainViewModel::class.java]
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