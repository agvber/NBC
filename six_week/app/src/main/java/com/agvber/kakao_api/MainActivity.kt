package com.agvber.kakao_api

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.agvber.kakao_api.databinding.ActivityMainBinding
import com.agvber.kakao_api.presentation.main.MainViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initView()
    }

    private fun initView() {
        setToolbar()
        setViewPager()
        setTabLayout()
    }

    private fun setViewPager() {
        binding.mainViewPager.adapter = MainViewPagerAdapter(this)
    }

    private fun setTabLayout() {
        TabLayoutMediator(
            binding.mainTabLayout,
            binding.mainViewPager
        ) { tab, position ->

            when (position) {

                0 -> {
                    tab.text = "Search"
                }

                1 -> {
                    tab.text = "Bookmark"
                }

            }

        }
            .attach()
    }

    private fun setToolbar() {
        setSupportActionBar(binding.mainToolbar)
        supportActionBar?.title = "Challenge"
    }
}