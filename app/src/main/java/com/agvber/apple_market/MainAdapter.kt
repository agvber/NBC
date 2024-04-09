package com.agvber.apple_market

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agvber.apple_market.databinding.RecyclerviewMainBinding
import com.agvber.apple_market.model.Post

class MainAdapter(
    private val items: List<Post>,
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: RecyclerviewMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            val currentItem = items[position]
            with(binding) {
                itemImageView.setImageResource(currentItem.image)
                titleTextView.text = currentItem.name
                addressTextView.text = currentItem.address
                priceTextView.text = currentItem.price.toString()
                chatCountTextView.text = currentItem.chat.toString()
                likeCountTextView.text = currentItem.like.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = RecyclerviewMainBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = items.size

}