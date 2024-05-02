package com.nbc.search_image.presenters.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nbc.search_image.databinding.RecyclerviewSearchItemBinding
import com.nbc.search_image.domain.model.Search
import java.time.format.DateTimeFormatter

class ImageSearchListAdapter(
    private val itemClickListener: (Search) -> Unit,
) : PagingDataAdapter<Search, ImageSearchListAdapter.ImageSearchListViewHolder>(diffCallback) {

    inner class ImageSearchListViewHolder(
        private val binding: RecyclerviewSearchItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                getItem(bindingAdapterPosition)?.let {
                    itemClickListener(it)
                }
            }
        }

        fun bind(position: Int) {
            val item = getItem(position) ?: return

            Glide.with(itemView.context)
                .load(item.image.thumbnailUrl)
                .into(binding.profileImageView)

            binding.titleTextView.text = item.title
            binding.contentTextView.text = item.dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            binding.likeBadgeImageView.visibility = if (item.isFavorite) View.VISIBLE else View.GONE
        }
    }

    override fun onBindViewHolder(holder: ImageSearchListViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSearchListViewHolder {
        val view = RecyclerviewSearchItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ImageSearchListViewHolder(view)
    }


    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Search>() {
            override fun areItemsTheSame(oldItem: Search, newItem: Search): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Search, newItem: Search): Boolean {
                return oldItem == newItem
            }
        }
    }
}