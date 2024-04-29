package com.agvber.kakao_api.presentation.search

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.agvber.kakao_api.databinding.RecyclerviewSearchBinding
import com.agvber.kakao_api.model.Images
import com.bumptech.glide.Glide

class SearchRecyclerViewAdapter(
    private val itemCheckedChangeListener: (Images.Item, Boolean) -> Unit
) : PagingDataAdapter<Images.Item, SearchRecyclerViewAdapter.SearchRecyclerViewHolder>(diffUtil) {

    private var itemCheckedContainer = setOf<String>()

    fun updateItemCheckedContainer(container: Set<String>) {
        itemCheckedContainer = container
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchRecyclerViewHolder {
        val view = RecyclerviewSearchBinding.inflate(
            /* inflater = */ LayoutInflater.from(parent.context),
            /* parent = */ parent,
            /* attachToParent = */ false
        )
        return SearchRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchRecyclerViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(holder.itemView.context, it) }
    }

    inner class SearchRecyclerViewHolder(
        private val binding: RecyclerviewSearchBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.customSwitch.setOnCheckedChangeListener { _, isChecked ->
                val item = getItem(bindingAdapterPosition) ?: return@setOnCheckedChangeListener
                itemCheckedChangeListener(item, isChecked)
            }
        }

        fun bind(context: Context, image: Images.Item) {
            Glide.with(context)
                .load(image.imageUrl.thumbnail)
                .into(binding.searchImageView)
            binding.siteNameTextView.text = image.site.name
            binding.customSwitch.isChecked = itemCheckedContainer.contains(image.imageUrl.image)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Images.Item>() {
            override fun areContentsTheSame(oldItem: Images.Item, newItem: Images.Item) =
                oldItem.imageUrl.image == newItem.imageUrl.image

            override fun areItemsTheSame(oldItem: Images.Item, newItem: Images.Item) =
                oldItem.imageUrl.image == newItem.imageUrl.image
        }
    }
}