package com.agvber.kakao_api.presentation.main

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.agvber.kakao_api.presentation.bookmark.BookmarkFragment
import com.agvber.kakao_api.presentation.search.SearchFragment

class MainViewPagerAdapter(
    activity: AppCompatActivity,
) : FragmentStateAdapter(activity.supportFragmentManager, activity.lifecycle) {

    private val fragments = listOf(
        SearchFragment(),
        BookmarkFragment()
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]
}