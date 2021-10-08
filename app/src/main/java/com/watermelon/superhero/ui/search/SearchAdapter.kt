package com.watermelon.superhero.ui.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.watermelon.superhero.R
import com.watermelon.superhero.databinding.ItemSearchRecyclerViewBinding
import com.watermelon.superhero.model.data.response.Hero

class SearchAdapter(private val list: List<Hero>) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {


    inner class ViewHolder(val binding: ItemSearchRecyclerViewBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSearchRecyclerViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("searchResult", list.toString())
        holder.binding.apply {
            with(list[position]) {
                textHeroName.text = name.toString()
                textHeroRealName.text = name.toString()
                loadImage(image?.url.toString(), itemImage)
                Log.i("searchResultTwo",textHeroName.text.toString())
            }

        }
    }

    override fun getItemCount() = list.size

    private fun loadImage(url: String, view: ImageView) {
        Glide.with(view.context).load(url)
            .placeholder(R.drawable.ic_baseline_downloading_24)
            .error(R.drawable.ic_baseline_error_outline_24)
            .into(view)
    }
}