package com.timotiushaniel.bajp3.ui.splashscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.timotiushaniel.bajp3.R
import com.timotiushaniel.bajp3.ui.home.HomeActivity

class SplashScreenActivity : AppCompatActivity() {
    private val splashTime: Long = 1100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }, splashTime)
    }
}