package com.watermelon.superhero.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.watermelon.superhero.R
import com.watermelon.superhero.databinding.ItemHeroBinding

class HeroAdapter(private val list: List<String>) :
    RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val item = R.layout.item_hero
        val view = LayoutInflater.from(parent.context).inflate(item, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {}

    override fun getItemCount() = list.size


    class HeroViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem) {
        val binding = ItemHeroBinding.bind(viewItem)
    }
}