package com.timotiushaniel.bajp3.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.synnapps.carouselview.ImageListener
import com.timotiushaniel.bajp3.R
import com.timotiushaniel.bajp3.databinding.ActivityHomeBinding
import com.timotiushaniel.bajp3.ui.favorite.FavoriteActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityHomeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(activityHomeBinding.root)

        activityHomeBinding.carouselView.pageCount = carouselImages.size
        activityHomeBinding.carouselView.setImageListener(imageListener)

        sectionsPageAdapterConf()
    }

    private fun sectionsPageAdapterConf() {
        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        supportActionBar?.elevation = 0f
    }

    private val carouselImages = intArrayOf(
        R.drawable.latar_a_star_is_born,
        R.drawable.latar_bohemian,
        R.drawable.latar_naruto_shippuden,
        R.drawable.latar_how_to_train,
        R.drawable.latar_infinity_war
    )

    private val imageListener = ImageListener { position, imageView ->
        imageView.setImageResource(carouselImages[position])
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favoriteActivity -> {
                val mIntent = Intent(this, FavoriteActivity::class.java)
                startActivity(mIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.movie,
            R.string.tv_show
        )
    }
}