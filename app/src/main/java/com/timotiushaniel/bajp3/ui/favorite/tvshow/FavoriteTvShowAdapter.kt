package com.timotiushaniel.bajp3.ui.favorite.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.timotiushaniel.bajp3.R
import com.timotiushaniel.bajp3.data.source.local.entity.TvShowEntity
import com.timotiushaniel.bajp3.databinding.ItemRowBinding
import com.timotiushaniel.bajp3.ui.detail.DetailActivity
import com.timotiushaniel.bajp3.ui.detail.DetailViewModel
import com.timotiushaniel.bajp3.utils.NetworkInfo
import timber.log.Timber

class FavoriteTvShowAdapter :
    PagedListAdapter<TvShowEntity, FavoriteTvShowAdapter.FavoriteTvShowViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FavoriteTvShowViewHolder {
        val itemsRowBinding =
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTvShowViewHolder(itemsRowBinding)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowViewHolder, position: Int) {
        val tvShows = getItem(position)
        if (tvShows != null) {
            holder.bind(tvShows)
        }
    }

    fun getSwipedData(swipedPosition: Int): TvShowEntity? = getItem(swipedPosition)

    class FavoriteTvShowViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShowEntity: TvShowEntity) {
            with(binding) {
                tvTitle.text = tvShowEntity.title

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_DATA, tvShowEntity.id)
                        putExtra(DetailActivity.EXTRA_CATEGORY, DetailViewModel.TV_SHOW)
                        Timber.d("ID: $tvShowEntity.id")
                        Timber.d("CATEGORY: ${DetailViewModel.TV_SHOW}")
                    }
                    it.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(NetworkInfo.IMAGE_URL + tvShowEntity.backdropPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    )
                    .into(imgItemPhoto)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}