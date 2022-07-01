package com.express.android.lwfirstandroid

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.express.android.lwfirstandroid.databinding.RecyclerviewRowBinding

class RecyclerViewAdapter() : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    var items = ArrayList<RecyclerData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RecyclerviewRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setListData(data: ArrayList<RecyclerData>) {
        this.items = data
    }

    inner class ViewHolder(val binding: RecyclerviewRowBinding) : RecyclerView.ViewHolder(binding.root) {

        val tvTitle = binding.tvTitle
        val tvDesc = binding.tvDesc
        val imageThumb = binding.imageThumb

        fun bind(data: RecyclerData) {
            tvTitle.text = data.name
            if(!TextUtils.isEmpty(data.description)) {
                tvDesc.text = data.description
            } else {
                tvDesc.text = "No desc available"
            }

            val url = data.owner.avatar_url
            Glide.with(imageThumb)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.default_thumb)
                .error(R.drawable.default_thumb)
                .fallback(R.drawable.default_thumb)
                .into(imageThumb)
        }
    }
}