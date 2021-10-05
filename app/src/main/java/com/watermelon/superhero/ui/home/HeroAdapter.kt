package com.watermelon.superhero.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.watermelon.superhero.R
import com.watermelon.superhero.databinding.ItemHeroBinding
import com.watermelon.superhero.model.data.response.Hero

class HeroAdapter(private val list: List<Hero>) :
    RecyclerView.Adapter<HeroAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemHeroBinding) : RecyclerView.ViewHolder(binding.root)

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val inflater = LayoutInflater.from(context)
        val binding = ItemHeroBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            with(list[position]) {
                heroName.text = name.toString()
                heroDescription.text = work?.occupation.toString()
                loadImage(image?.url.toString(), heroImage)
            }
        }
    }

    override fun getItemCount() = list.size

    private fun loadImage(url: String, view: ImageView) {
        Glide.with(context).load(url)
            .placeholder(R.drawable.ic_baseline_downloading_24)
            .error(R.drawable.ic_baseline_error_outline_24)
            .into(view)
    }
}