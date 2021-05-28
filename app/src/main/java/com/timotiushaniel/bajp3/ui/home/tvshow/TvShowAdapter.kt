package com.timotiushaniel.bajp3.ui.home.tvshow

import android.annotation.SuppressLint
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
import com.timotiushaniel.bajp3.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.timotiushaniel.bajp3.utils.NetworkInfo

class TvShowAdapter :
    PagedListAdapter<TvShowEntity, TvShowAdapter.TvShowsViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val itemsRowBinding =
            ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(itemsRowBinding)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val tvShows = getItem(position)
        if (tvShows != null) {
            holder.bind(tvShows)
        }
    }

    class TvShowsViewHolder(private val binding: ItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieEntity: TvShowEntity) {
            with(binding) {
                tvTitle.text = movieEntity.title

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java).apply {
                        putExtra(DetailActivity.EXTRA_DATA, movieEntity.id)
                        putExtra(DetailActivity.EXTRA_CATEGORY, TV_SHOW)
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
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}