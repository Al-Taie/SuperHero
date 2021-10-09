package com.watermelon.superhero.ui.interfaces

import android.widget.ImageView
import com.watermelon.superhero.model.data.response.Hero

interface HomeListener {
    fun updateHomeUI(result: List<Hero>)
    fun onItemClicked(imageView: ImageView, hero: Hero)
}
