package com.agvber.kakao_api.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.agvber.kakao_api.databinding.RecyclerviewImageBinding
import com.agvber.kakao_api.databinding.RecyclerviewVideoBinding
import com.agvber.kakao_api.domain.model.Image
import com.agvber.kakao_api.domain.model.Video
import com.bumptech.glide.Glide

private enum class HomeViewHolder {
    IMAGE, VIDEO
}

class HomeListAdapter : ListAdapter<HomeViewUiState, RecyclerView.ViewHolder>(diffUtil) {

    class ImageViewHolder(private val binding: RecyclerviewImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(image: Image) {
            Glide.with(itemView.context)
                .load(image.thumbnailUrl)
                .into(binding.imageView)

            binding.titleTextView.text = image.title
            binding.descriptionTextView.text = image.content
            binding.dateTimeTextView.text = image.dateTime.toString()
        }
    }

    class VideoViewHolder(private val binding: RecyclerviewVideoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(video: Video) {
            Glide.with(itemView.context)
                .load(video.thumbnailUrl)
                .into(binding.imageView)

            binding.titleTextView.text = video.title
            binding.descriptionTextView.text = video.sourceUrl
            binding.dateTimeTextView.text = video.dateTime.toString()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ImageViewHolder -> {
                getItem(position)?.let {
                    holder.bind((it as HomeViewUiState.ImageItem).data)
                }
            }

            is VideoViewHolder -> {
                getItem(position)?.let {
                    holder.bind((it as HomeViewUiState.VideoItem).data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            HomeViewHolder.IMAGE.ordinal -> {
                ImageViewHolder(
                    RecyclerviewImageBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            HomeViewHolder.VIDEO.ordinal -> {
                VideoViewHolder(
                    RecyclerviewVideoBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> throw IllegalStateException()
        }


    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)) {
            is HomeViewUiState.ImageItem -> HomeViewHolder.IMAGE.ordinal
            is HomeViewUiState.VideoItem -> HomeViewHolder.VIDEO.ordinal
            else -> throw IllegalStateException()
        }
    }

    companion object {
        private val diffUtil = object : DiffUtil.ItemCallback<HomeViewUiState>() {
            override fun areItemsTheSame(
                oldItem: HomeViewUiState,
                newItem: HomeViewUiState,
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: HomeViewUiState,
                newItem: HomeViewUiState,
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

}