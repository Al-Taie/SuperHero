package com.watermelon.superhero.presenter

import com.watermelon.superhero.model.data.response.Hero

interface ISearchPresenter {
    fun onSearchResult(result: List<Hero>)
    fun showLoading()
    fun hideLoading()
    fun showError()
}