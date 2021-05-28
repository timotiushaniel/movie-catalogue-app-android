package com.timotiushaniel.bajp3.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.timotiushaniel.bajp3.R
import com.timotiushaniel.bajp3.databinding.FragmentFavoriteTvShowBinding
import com.timotiushaniel.bajp3.viewModel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {

    private var _fragmentFavoriteTvShowBinding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _fragmentFavoriteTvShowBinding

    private lateinit var viewModel: FavoriteTvShowViewModel
    private lateinit var adapter: FavoriteTvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavoriteTvShowBinding =
            FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvTvShowFav)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]

            adapter = FavoriteTvShowAdapter()
            showProgressBar()
            viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, { tvShow ->
                hideProgressBar()
                adapter.submitList(tvShow)
                binding?.viewEmptyTvshow?.root?.visibility =
                    if (tvShow.isNotEmpty()) View.GONE else View.VISIBLE
            })

            binding?.rvTvShowFav?.layoutManager = LinearLayoutManager(context)
            binding?.rvTvShowFav?.setHasFixedSize(true)
            binding?.rvTvShowFav?.adapter = adapter
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvShowEntity = adapter.getSwipedData(swipedPosition)
                tvShowEntity?.let { viewModel.setFavoriteTvShows(it) }
                val snackBar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.message_ok) { v ->
                    tvShowEntity?.let { viewModel.setFavoriteTvShows(it) }
                }
                snackBar.show()
            }
        }
    })

    private fun showProgressBar() {
        binding?.progressBarFav?.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding?.progressBarFav?.visibility = View.GONE
    }
}