package com.watermelon.superhero.presenter

import com.watermelon.superhero.model.data.Status
import com.watermelon.superhero.model.repository.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchPresenter {
     lateinit var view:ISearchPresenter


    fun getSearch(){

        val dispatcher = Dispatchers.Main

        CoroutineScope(dispatcher).launch  {
            MainRepository.getSuperHeroSearch().collect { response ->
                when (response) {
                    is Status.Success -> response.data.results?.let { result ->

                        view.onSearchResult(result)
                    }
                    is Status.Loading -> { view.showLoading() }
                    is Status.Fail -> { view.showError() }
                }
            }
        }
    }

}