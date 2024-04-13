package com.caiosilva.projetomarcel2tdsps

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.caiosilva.projetomarcel2tdsps.databinding.ComicListItemBinding

class ComicsAdapter : ListAdapter<PhotoPost, ComicsAdapter.ComicsViewHolder>(DiffCallback()) {

    var onclickListener: (photoPost: PhotoPost) -> Unit = {}

    inner class ComicsViewHolder(val binding: ComicListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photoPost: PhotoPost) {
            binding.textViewTitle.text = photoPost.title
            binding.textViewDescription.text = photoPost.thumbnailUrl
            binding.textViewPageCount.text = photoPost.id.toString()
            binding.imageViewThumbnail.setImageFromUrl(photoPost.thumbnailUrl)
            binding.root.setOnClickListener {
                onclickListener(photoPost)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<PhotoPost>() {
        override fun areItemsTheSame(oldItem: PhotoPost, newItem: PhotoPost): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PhotoPost, newItem: PhotoPost): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val itemView: ComicListItemBinding =
            ComicListItemBinding.inflate(layoutInflater, parent, false)
        val viewHolder: ComicsViewHolder = ComicsViewHolder(itemView)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(
            getItem(position)
        )
    }

    companion object {
        private const val VIEW_TYPE_HERO = 1
        private const val VIEW_TYPE_VILLAIN = 2
    }
}