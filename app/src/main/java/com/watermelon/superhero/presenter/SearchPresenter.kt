package com.watermelon.superhero.presenter

import com.watermelon.superhero.model.data.Status
import com.watermelon.superhero.model.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class SearchPresenter {

    lateinit var view: ISearchPresenter

    @FlowPreview
    fun getSearch(text: CharSequence?) {

        val dispatcher = Dispatchers.Main

        CoroutineScope(dispatcher).launch {
            MainRepository.getSuperHeroSearch(text).debounce(1500).collect { response ->
                when (response) {
                    is Status.Success -> response.data.results?.let { result ->
                        view.onSearchResult(result)

                    }
                    is Status.Loading -> {
                        view.showLoading()
                    }
                    is Status.Fail -> {
                        view.showError()
                    }
                }
            }
        }
    }

}