package com.timotiushaniel.bajp3.ui.favorite

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.timotiushaniel.bajp3.R
import com.timotiushaniel.bajp3.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(activityFavoriteBinding.root)

        sectionsPageAdapterConf()
        setActionBarTitle()
    }

    private fun sectionsPageAdapterConf() {
        val sectionsPagerAdapter = FavoriteSectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager_favorite)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs_favorite)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }

    private fun setActionBarTitle() {
        if (supportActionBar != null) {
            supportActionBar?.title = "Favorite Items"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.movie,
            R.string.tv_show
        )
    }
}