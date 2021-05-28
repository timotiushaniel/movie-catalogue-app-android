package com.timotiushaniel.bajp3.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.timotiushaniel.bajp3.ui.favorite.movies.FavoriteMoviesFragment
import com.timotiushaniel.bajp3.ui.favorite.tvshow.FavoriteTvShowFragment

class FavoriteSectionsPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null

        fragment = if (position == 0) {
            FavoriteMoviesFragment()
        } else {
            FavoriteTvShowFragment()
        }
        return fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}