package com.watermelon.superhero.presenter

import android.util.Log
import com.watermelon.superhero.model.data.Status
import com.watermelon.superhero.model.data.response.Hero
import com.watermelon.superhero.model.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class SearchPresenter {
    lateinit var view: ISearchPresenter

    @FlowPreview
    fun getSearch(text: String) {
        val dispatcher = Dispatchers.Main

        CoroutineScope(dispatcher).launch {
            MainRepository.getSuperHero(text).debounce(1500).catch {
                view.showError()
            }.collect { response ->
                when (response) {
                    is Status.Success -> response.data.results?.let { result ->
                        MainRepository.initHeroList(result)
                        view.onSearchResult(result)
                        //getSearchListFromMain()
                    }
                    is Status.Loading -> view.showLoading()
                    is Status.Fail -> view.hideLoading()
                }
            }
        }
    }

    fun getSearchListFromMain():List<Hero> {
       return MainRepository.heroes
       // Log.i("inti",MainRepository.heroes.toString())
    }
}