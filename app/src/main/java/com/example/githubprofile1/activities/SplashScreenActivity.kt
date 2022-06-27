package com.example.githubprofile1.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.githubprofile1.databinding.ActivitySplashScreenBinding
import com.example.githubprofile1.helpers.Config

class SplashScreenActivity : AppCompatActivity() {

        private lateinit var binding: ActivitySplashScreenBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivitySplashScreenBinding.inflate(layoutInflater)
            setContentView(binding.root)

            Handler(mainLooper).postDelayed({
                startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                finish()
            }, Config.SPLASH_SCREEN_DELAY)
        }
    }