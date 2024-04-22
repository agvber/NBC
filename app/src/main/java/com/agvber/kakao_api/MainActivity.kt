package com.agvber.kakao_api

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.viewpager2.widget.ViewPager2
import com.agvber.kakao_api.databinding.ActivityMainBinding
import com.agvber.kakao_api.presentation.main.MainViewPagerAdapter
import com.agvber.kakao_api.presentation.search.SearchFragment
import com.google.android.material.tabs.TabLayout

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
        setTabLayout()
        setViewPager()
    }

    private fun setViewPager() {
        binding.mainViewPager.adapter = MainViewPagerAdapter(listOf("Search", "Bookmark")) { item ->
            Log.d("MainViewPager", "pageIndex: $item")

            supportFragmentManager.commit {
                when (item) {
                    "Search" -> {
                        add(R.id.fragment_container_view, SearchFragment())
                        binding.mainTabLayout.setScrollPosition(0, 0f, false)
                    }
                    "Bookmark" -> {
                        binding.mainTabLayout.setScrollPosition(1, 0f, false)
                    }
                }
            }
        }

        binding.mainViewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.mainTabLayout.setScrollPosition(position, 0f, false)
                }
            }
        )
    }

    private fun setTabLayout() {
        binding.mainTabLayout.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(p0: TabLayout.Tab?) {
                    if (p0 == null) return

                    when (p0.text) {
                        "Search" -> {
                            binding.mainViewPager.setCurrentItem(0, true)
                        }
                        "Bookmark" -> {
                            binding.mainViewPager.setCurrentItem(1, true)
                        }
                    }
                }

                override fun onTabUnselected(p0: TabLayout.Tab?) {

                }

                override fun onTabReselected(p0: TabLayout.Tab?) {

                }
            }
        )
    }

    private fun setToolbar() {
        setSupportActionBar(binding.mainToolbar)
        supportActionBar?.title = "Challenge"
    }
}