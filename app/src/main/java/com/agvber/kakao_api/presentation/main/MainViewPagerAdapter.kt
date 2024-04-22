package com.agvber.kakao_api.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agvber.kakao_api.databinding.ViewpagerMainBinding

class MainViewPagerAdapter(
    private val items: List<String>,
    private val bindCallback: (String) -> Unit
): RecyclerView.Adapter<MainViewPagerAdapter.MainViewPagerViewHolder>() {

    inner class MainViewPagerViewHolder(
        binding: ViewpagerMainBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            bindCallback(items[position])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewPagerViewHolder {
        val view = ViewpagerMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewPagerViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = items.size
}