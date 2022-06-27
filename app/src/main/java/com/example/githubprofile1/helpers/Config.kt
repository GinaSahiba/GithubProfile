package com.example.githubprofile1.helpers

import com.example.githubprofile1.BuildConfig

class Config {
    companion object{
        const val SPLASH_SCREEN_DELAY:Long = 3000
        const val BASE_URL ="https://api.github.com"
        const val DEFAULT_USER_LOGIN = "ginasahiba"
        const val PERSONAL_ACCESS_TOKEN = "token ${BuildConfig.ACCESS_TOKEN}"

    }
}