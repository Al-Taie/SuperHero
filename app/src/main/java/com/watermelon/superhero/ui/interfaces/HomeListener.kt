package com.watermelon.superhero.ui.interfaces

import com.watermelon.superhero.model.data.response.Hero

interface HomeListener {
    fun updateHomeUI(result: List<Hero>)
}
