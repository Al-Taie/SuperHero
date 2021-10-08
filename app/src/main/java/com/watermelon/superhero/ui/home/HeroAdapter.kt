package com.watermelon.superhero.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.watermelon.superhero.R
import com.watermelon.superhero.databinding.ItemHeroBinding
import com.watermelon.superhero.model.data.response.Hero

class HeroAdapter(private val list: List<Hero>) :
    RecyclerView.Adapter<HeroAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemHeroBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHeroBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            with(list[position]) {
                val imageUrl = image?.url.toString()
                heroName.text = name.toString()
                loadImage(imageUrl, heroImage)
                heroImage.setOnClickListener { view ->
                    val action = HomeFragmentDirections.actionHomeFragmentToBiographyFragment(imageUrl)
                    val extras = FragmentNavigatorExtras(
                        heroImage to view.context.getString(R.string.image_transition)
                    )
                    Navigation.findNavController(view).navigate(action,extras)
                }
                heroDescription.text = work?.occupation.toString()
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