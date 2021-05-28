package com.timotiushaniel.bajp3.ui.favorite.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.timotiushaniel.bajp3.R
import com.timotiushaniel.bajp3.data.source.local.entity.MovieEntity
import com.timotiushaniel.bajp3.databinding.ItemRowBinding
import com.timotiushaniel.bajp3.ui.detail.DetailActivity
import com.timotiushaniel.bajp3.ui.detail.DetailViewModel
import com.timotiushaniel.bajp3.utils.NetworkInfo
import timber.log.Timber

class FavoriteMoviesAdapter :
    PagedListAdapter<MovieEntity, FavoriteMoviesAdapter.FavoriteMoviesViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteMoviesViewHolder {
        val itemsRowBinding =
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMoviesViewHolder(itemsRowBinding)
    }

    override fun onBindViewHolder(holder: FavoriteMoviesViewHolder, position: Int) {
        val movies = getItem(position)
        if (movies != null) {
            holder.bind(movies)
        }
    }

    fun getSwipedData(swipedPosition: Int): MovieEntity? = getItem(swipedPosition)

    class FavoriteMoviesViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieEntity: MovieEntity) {
            with(binding) {
                tvTitle.text = movieEntity.title

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_DATA, movieEntity.id)
                        putExtra(DetailActivity.EXTRA_CATEGORY, DetailViewModel.MOVIE)
                        Timber.d("ID: $movieEntity.id")
                        Timber.d("CATEGORY: ${DetailViewModel.MOVIE}")
                    }
                    it.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(NetworkInfo.IMAGE_URL + movieEntity.backdropPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgItemPhoto)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}