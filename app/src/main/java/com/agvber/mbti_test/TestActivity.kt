package com.agvber.mbti_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.agvber.mbti_test.databinding.ActivityBaseBinding
import com.agvber.mbti_test.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding
    val questionnaireResults = QuestionnaireResults()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = ViewPagerAdapter(this)
        binding.viewPager.isUserInputEnabled = false
    }

    fun moveToNextQuestion() {
        if (binding.viewPager.currentItem==3) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("results", ArrayList(questionnaireResults.results))
            startActivity(intent)
        } else {
            val nextItem = binding.viewPager.currentItem + 1
            if (nextItem < (binding.viewPager.adapter?.itemCount ?: 0)) {
                binding.viewPager.setCurrentItem(nextItem, true)
            }
        }
    }
}

class QuestionnaireResults {
    val results = mutableListOf<Int>()

    fun addResponses(responses: List<Int>) {
        val mostFrequent = responses.groupingBy { it }.eachCount().maxByOrNull { it.value }?.key
        mostFrequent?.let { results.add(it) }
    }
}