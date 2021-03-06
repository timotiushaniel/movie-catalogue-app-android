package com.timotiushaniel.bajp3.ui.home.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.timotiushaniel.bajp3.databinding.FragmentMoviesBinding
import com.timotiushaniel.bajp3.viewModel.ViewModelFactory
import com.timotiushaniel.bajp3.vo.Status

class MoviesFragment : Fragment() {

    private lateinit var fragmentMoviesBinding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentMoviesBinding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return fragmentMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]

            val moviesAdapter = MoviesAdapter()
            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                if (movies != null) {
                    when (movies.status) {
                        Status.LOADING -> showProgressBar()
                        Status.SUCCESS -> {
                            moviesAdapter.submitList(movies.data)
                            hideProgressBar()
                        }
                        Status.ERROR -> {
                            Toast.makeText(
                                context,
                                "Error...",
                                Toast.LENGTH_SHORT
                            ).show()
                            showProgressBar()
                        }
                    }
                }

            })

            with(fragmentMoviesBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = moviesAdapter
            }
        }
    }

    private fun showProgressBar() {
        fragmentMoviesBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        fragmentMoviesBinding.progressBar.visibility = View.INVISIBLE
    }
}
