package com.timotiushaniel.bajp3.ui.detail

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.timotiushaniel.bajp3.R
import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity
import com.timotiushaniel.bajp3.databinding.ActivityDetailBinding
import com.timotiushaniel.bajp3.utils.GenreConverter
import com.timotiushaniel.bajp3.utils.NetworkInfo.IMAGE_URL
import com.timotiushaniel.bajp3.viewModel.ViewModelFactory
import com.timotiushaniel.bajp3.vo.Status
import timber.log.Timber

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    private val genreHelper = GenreConverter()
    private lateinit var categoryName: String
    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        binding.fab.setOnClickListener(this)

        val dataId = intent.extras?.getInt(EXTRA_DATA)
        val category = intent.extras?.getString(EXTRA_CATEGORY)
        Timber.d("DATA ID: $dataId")
        Timber.d("CATEGORY: $category")
        if (dataId != null && category != null) {
            if (category == "movie") {
                categoryName = category
                viewModel.setSelectedMovies(dataId.toInt())
                viewModel.getMoviesDetail().observe(this, { movies ->
                    when (movies.status) {
                        Status.SUCCESS -> {
                            if (movies.data != null) {
                                hideProgressBar()
                                populateMovieDetailData(movies.data)
                                setupState()
                            }
                        }
                        Status.ERROR -> {
                            showProgressBar()
                            Toast.makeText(
                                applicationContext,
                                "Error...",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        Status.LOADING -> showProgressBar()

                    }
                })
            } else if (category == "tvShow") {
                categoryName = category
                viewModel.setSelectedTvShow(dataId.toInt())
                viewModel.getTvShowDetail().observe(this, { tvShow ->
                    when (tvShow.status) {
                        Status.SUCCESS -> {
                            if (tvShow.data != null) {
                                hideProgressBar()
                                populateTvShowDetailData(tvShow.data)
                                setupState()
                            }
                        }
                        Status.ERROR -> {
                            showProgressBar()
                            Toast.makeText(
                                applicationContext,
                                "Error...",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        Status.LOADING -> showProgressBar()
                    }
                })
            }
        }
    }

    private fun setupState() {
        if (categoryName == "movie") {
            viewModel.getMoviesDetail().observe(this, { movie ->
                when (movie.status) {
                    Status.SUCCESS -> {
                        if (movie.data != null) {
                            val state = movie.data.isFavorite
                            setFavoriteState(state)
                            isFavorite = state
                            hideProgressBar()
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(
                            applicationContext,
                            "Error...",
                            Toast.LENGTH_SHORT
                        ).show()
                        showProgressBar()
                    }
                    Status.LOADING -> showProgressBar()
                }
            })
        } else if (categoryName == "tvShow") {
            viewModel.getTvShowDetail().observe(this, { tvShow ->
                when (tvShow.status) {
                    Status.SUCCESS -> {
                        if (tvShow.data != null) {
                            val state = tvShow.data.isFavorite
                            setFavoriteState(state)
                            isFavorite = state
                            hideProgressBar()
                        }
                    }
                    Status.ERROR -> {
                        Toast.makeText(
                            applicationContext,
                            "Error...",
                            Toast.LENGTH_SHORT
                        ).show()
                        showProgressBar()
                    }
                    Status.LOADING -> showProgressBar()
                }
            })
        }
    }

    override fun onClick(view: View) {
        if (view.id == R.id.fab) {
            if (categoryName == "movie") {
                viewModel.setFavoriteMovie()
                toastNotification()
            } else if (categoryName == "tvShow") {
                viewModel.setFavoriteTvShow()
                toastNotification()
            }
        }
    }

    private fun toastNotification() {
        if (isFavorite) {
            Toast.makeText(
                applicationContext,
                "Item has been removed from favorite",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            Toast.makeText(
                applicationContext,
                "Item has been added to favorite",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun setActionBarTitle(name: String) {
        supportActionBar?.title = name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun setFavoriteState(state: Boolean) {
        if (state) {
            binding.fab.setImageResource(R.drawable.ic_thumb_down)
        } else {
            binding.fab.setImageResource(R.drawable.ic_thumb_up)
        }
    }

    private fun populateMovieDetailData(detailDataEntity: MovieEntity) {
        binding.tvTitle.text = detailDataEntity.title
        binding.tvDesc.text = detailDataEntity.overview
        binding.tvReleaseDate.text = detailDataEntity.releaseYear?.split("-")?.get(0).toString()
        val genre = detailDataEntity.genre.toString().replace("[", "").replace("]", "")
        binding.tvGenre.text = genreHelper.getGenreName(genre, "movie")
        binding.tvRating.text = detailDataEntity.voteAverage.toString()

        detailDataEntity.posterPath?.let { binding.imgItemPreview.loadImage(it) }
        detailDataEntity.backdropPath?.let { binding.imgItemPhoto.loadImage(it) }

        detailDataEntity.title?.let { setActionBarTitle(it) }
    }

    private fun populateTvShowDetailData(detailDataEntity: TvShowEntity) {
        binding.tvTitle.text = detailDataEntity.title
        binding.tvDesc.text = detailDataEntity.overview
        binding.tvReleaseDate.text = detailDataEntity.releaseYear?.split("-")?.get(0).toString()
        val genre = detailDataEntity.genre.toString().replace("[", "").replace("]", "")
        binding.tvGenre.text = genreHelper.getGenreName(genre, "tvshow")
        binding.tvRating.text = detailDataEntity.voteAverage.toString()

        detailDataEntity.posterPath?.let { binding.imgItemPreview.loadImage(it) }
        detailDataEntity.backdropPath?.let { binding.imgItemPhoto.loadImage(it) }

        detailDataEntity.title?.let { setActionBarTitle(it) }
    }

    private fun ImageView.loadImage(url: String) {
        Glide.with(this.context)
            .load(IMAGE_URL + url)
            .into(this)
    }

    private fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.progressBar.visibility = View.INVISIBLE
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
        const val EXTRA_CATEGORY = "extra_category"
    }
}