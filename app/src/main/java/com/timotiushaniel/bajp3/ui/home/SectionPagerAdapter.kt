package com.timotiushaniel.bajp3.ui.home

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.timotiushaniel.bajp3.ui.home.movies.MoviesFragment
import com.timotiushaniel.bajp3.ui.home.tvshow.TvShowFragment

class SectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null

        fragment = if (position == 0) {
            MoviesFragment()
        } else {
            TvShowFragment()
        }
        return fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}