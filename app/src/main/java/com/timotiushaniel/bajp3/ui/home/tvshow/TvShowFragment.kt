package com.timotiushaniel.bajp3.ui.home.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.timotiushaniel.bajp3.databinding.FragmentTvShowBinding
import com.timotiushaniel.bajp3.viewModel.ViewModelFactory
import com.timotiushaniel.bajp3.vo.Status

class TvShowFragment : Fragment() {

    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]

            val tvShowAdapter = TvShowAdapter()
            viewModel.getTvShow().observe(viewLifecycleOwner, { tvShows ->
                if (tvShows != null) {
                    when (tvShows.status) {
                        Status.LOADING -> showProgressBar()
                        Status.SUCCESS -> {
                            tvShowAdapter.submitList(tvShows.data)
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

            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    private fun showProgressBar() {
        fragmentTvShowBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        fragmentTvShowBinding.progressBar.visibility = View.INVISIBLE
    }
}
