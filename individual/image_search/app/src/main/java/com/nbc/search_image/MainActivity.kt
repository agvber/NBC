package com.nbc.search_image

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import com.nbc.search_image.databinding.ActivityMainBinding
import com.nbc.search_image.presenters.bookmark.BookmarkFragment
import com.nbc.search_image.presenters.search.SearchFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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

        init()
        clickSearchButton()
        clickBookmarkButton()
    }

    private fun init() {
        supportFragmentManager.commit {
            add(binding.rootFragmentContainer.id, SearchFragment())
        }
    }

    private fun clickSearchButton() =
        binding.searchButton.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.rootFragmentContainer.id, SearchFragment())
            }
        }

    private fun clickBookmarkButton() =
        binding.bookmarkButton.setOnClickListener {
            supportFragmentManager.commit {
                replace(binding.rootFragmentContainer.id, BookmarkFragment())
            }
        }
}