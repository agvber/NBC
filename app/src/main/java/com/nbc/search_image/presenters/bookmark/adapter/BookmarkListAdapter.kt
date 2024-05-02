package com.nbc.search_image.presenters.bookmark.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nbc.search_image.databinding.RecyclerviewBookmarkItemBinding
import com.nbc.search_image.domain.model.Bookmark
import java.time.format.DateTimeFormatter

class BookmarkListAdapter(
    private val itemClickListener: (Bookmark) -> Unit,
) : ListAdapter<Bookmark, BookmarkListAdapter.BookmarkViewHolder>(diffCallback) {

    inner class BookmarkViewHolder(
        private val binding: RecyclerviewBookmarkItemBinding,
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
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val view =
            RecyclerviewBookmarkItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return BookmarkViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.bind(position)
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Bookmark>() {
            override fun areItemsTheSame(oldItem: Bookmark, newItem: Bookmark): Boolean {
                return oldItem.id == newItem.id

            }

            override fun areContentsTheSame(oldItem: Bookmark, newItem: Bookmark): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }
}