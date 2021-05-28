package com.timotiushaniel.bajp3.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.timotiushaniel.bajp3.R
import com.timotiushaniel.bajp3.utils.DataDummy
import com.timotiushaniel.bajp3.utils.EspressoIdlingResource
import org.hamcrest.core.AllOf.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val dummyMovies = DataDummy.getMovies()
    private val dummyTvShows = DataDummy.getTvShows()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovie() {
        onView(withText("MOVIE")).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadMovieDetail() {
        onView(withText("MOVIE")).perform(click())
        onView(
            allOf(
                withId(R.id.rv_movie),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_item_preview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.img_item_photo)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShows.size
            )
        )
    }

    @Test
    fun loadTvShowDetail() {
        onView(withText("TV SHOW")).perform(click())
        onView(
            allOf(
                withId(R.id.rv_tv_show),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_item_preview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.img_item_photo)).check(matches(isDisplayed()))
    }

    @Test
    fun loadFavoriteMovies() {
        onView(withText("MOVIE")).perform(click())
        onView(
            allOf(
                withId(R.id.rv_movie),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fab)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.favoriteActivity)).perform(click())
        onView(withText("MOVIE")).perform(click())
        onView(
            allOf(
                withId(R.id.rv_movie_favorite),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_item_preview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.img_item_photo)).check(matches(isDisplayed()))
        onView(withId(R.id.fab)).perform(click())
    }

    @Test
    fun loadFavoriteTvShows() {
        onView(withText("TV SHOW")).perform(click())
        onView(
            allOf(
                withId(R.id.rv_tv_show),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.fab)).perform(click())
        onView(isRoot()).perform(pressBack())
        onView(withId(R.id.favoriteActivity)).perform(click())
        onView(withText("TV SHOW")).perform(click())
        onView(
            allOf(
                withId(R.id.rv_tv_show_fav),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_item_preview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_release_date)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_desc)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).perform(swipeUp()).check(matches(isDisplayed()))
        onView(withId(R.id.img_item_photo)).check(matches(isDisplayed()))
        onView(withId(R.id.fab)).perform(click())
    }
}