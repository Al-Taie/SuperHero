package com.watermelon.superhero.ui.interfaces

import com.watermelon.superhero.model.data.response.Hero

interface IMainView {
    fun showLoading()
    fun hideLoading()
    fun showError()
    fun updateUI(result: List<Hero>)
}