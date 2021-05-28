package com.timotiushaniel.bajp3.ui.favorite.movies

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
import com.timotiushaniel.bajp3.databinding.FragmentFavoriteMoviesBinding
import com.timotiushaniel.bajp3.viewModel.ViewModelFactory

class FavoriteMoviesFragment : Fragment() {

    private var _fragmentFavoriteMoviesBinding: FragmentFavoriteMoviesBinding? = null
    private val binding get() = _fragmentFavoriteMoviesBinding

    private lateinit var viewModel: FavoriteMoviesViewModel
    private lateinit var adapter: FavoriteMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _fragmentFavoriteMoviesBinding =
            FragmentFavoriteMoviesBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(binding?.rvMovieFavorite)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteMoviesViewModel::class.java]

            adapter = FavoriteMoviesAdapter()
            showProgressBar()
            viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { movies ->
                hideProgressBar()
                adapter.submitList(movies)
                binding?.viewEmptyMovie?.root?.visibility =
                    if (movies.isNotEmpty()) View.GONE else View.VISIBLE
            })

            binding?.rvMovieFavorite?.layoutManager = LinearLayoutManager(context)
            binding?.rvMovieFavorite?.setHasFixedSize(true)
            binding?.rvMovieFavorite?.adapter = adapter
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
                val movieEntity = adapter.getSwipedData(swipedPosition)
                movieEntity?.let { viewModel.setFavoriteMovies(it) }
                val snackBar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.message_ok) { v ->
                    movieEntity?.let { viewModel.setFavoriteMovies(it) }
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