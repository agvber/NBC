package com.agvber.apple_market.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agvber.apple_market.R
import com.agvber.apple_market.databinding.RecyclerviewMainBinding
import com.agvber.apple_market.model.Post
import java.text.NumberFormat

class MainAdapter(
    private val items: List<Post>,
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private val numberFormat = NumberFormat.getInstance()

    inner class ViewHolder(private val binding: RecyclerviewMainBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(context: Context, position: Int) {
            val currentItem = items[position]
            with(binding) {
                itemImageView.setImageResource(currentItem.image)
                titleTextView.text = currentItem.name
                addressTextView.text = currentItem.address
                priceTextView.text = "${numberFormat.format(currentItem.price)}${context.getString(R.string.currency)}"
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
        holder.bind(holder.itemView.context, position)
    }

    override fun getItemCount(): Int = items.size

}