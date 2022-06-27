package com.example.githubprofile1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.githubprofile1.GlideApp
import com.bumptech.glide.request.RequestOptions
import com.example.githubprofile1.R
import com.example.githubprofile1.databinding.ActivityMainBinding
import com.example.githubprofile1.helpers.Config
import com.example.githubprofile1.models.GithubUser
import com.example.githubprofile1.services.GithubUserService
import com.example.githubprofile1.services.ServiceBuilder
import com.example.githubprofile1.viewmodels.MainViewModel
import retrofit2.Call

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val mainViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            MainViewModel::class.java)
        mainViewModel.githubUser.observe(this) { user ->
            setUserData(user)
        }

        mainViewModel.isLoading.observe(this) {
            showLoading(it)
        }

        binding.btnSearchUserLogin.setOnClickListener {
            val userLogin = binding.etSearchUserLogin.text.toString()
            var query = Config.DEFAULT_USER_LOGIN
            if (userLogin.isNotEmpty()) {
                query = userLogin
            }
            mainViewModel.searchUser(query)
        }
    }

    private fun setUserData(githubUser: GithubUser) {
        binding.tvUser.text = githubUser.toString()
        GlideApp.with(applicationContext)
            .load(githubUser.avatarUrl)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_baseline_image_24)
                    .error(R.drawable.ic_baseline_broken_image_24))
            .into(binding.imgUser)
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }
}