package com.agvber.apple_market.ui.detail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.agvber.apple_market.R
import com.agvber.apple_market.databinding.ActivityDetailBinding
import com.agvber.apple_market.model.Post
import com.agvber.apple_market.ui.getCustomParcelableExtra
import java.text.NumberFormat

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val numberFormat = NumberFormat.getNumberInstance()
        val post = intent.getCustomParcelableExtra(POST_DATA, Post::class.java)

        binding.backButtonImageView.setOnClickListener {
            finish()
        }

        with(binding) {
            itemImageView.setImageResource(post.image)
            nameTextView.text = post.seller
            addressTextView.text = post.address
            priceTextView.text = "${numberFormat.format(post.price)}${getString(R.string.currency)}"
            titleTextView.text = post.name
            descriptionTextView.text = post.description
        }
    }

    companion object {
        const val POST_DATA = "post_data"
    }
}