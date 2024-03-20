package com.caiosilva.projetomarcel2tdsps

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.caiosilva.projetomarcel2tdsps.databinding.ComicListItemBinding

class ComicsAdapter : ListAdapter<ComicBookData, ComicsAdapter.ComicsViewHolder>(DiffCallback()) {

    inner class ComicsViewHolder(val binding: ComicListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(comicBookData: ComicBookData) {
            binding.textViewTitle.text = comicBookData.title
            binding.textViewDescription.text = comicBookData.description
            binding.textViewPageCount.text = comicBookData.pageCount.toString()
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<ComicBookData>() {
        override fun areItemsTheSame(oldItem: ComicBookData, newItem: ComicBookData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ComicBookData, newItem: ComicBookData): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val itemView: ComicListItemBinding = ComicListItemBinding.inflate(layoutInflater)
        val viewHolder: ComicsViewHolder = ComicsViewHolder(itemView)

        return viewHolder
    }

    override fun onBindViewHolder(holder: ComicsViewHolder, position: Int) {
        holder.bind(
            getItem(position)
        )
    }
}