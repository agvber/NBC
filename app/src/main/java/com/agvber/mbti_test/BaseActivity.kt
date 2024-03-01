package com.agvber.mbti_test

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.agvber.mbti_test.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivStart.setOnClickListener {
            startTestActivity(this)
        }
    }
}

private fun startTestActivity(context: Context) {
    val intent = Intent(context, TestActivity::class.java)
    context.startActivity(intent)
}