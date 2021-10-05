package com.watermelon.superhero.presenter

import com.watermelon.superhero.model.data.Status
import com.watermelon.superhero.model.repository.MainRepository
import com.watermelon.superhero.ui.interfaces.IMainView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomePresenter : IHomePresenter {
    lateinit var view: IMainView

    override fun bindOnUI() {
        val dispatcher = Dispatchers.Main
        val repository = MainRepository

        CoroutineScope(dispatcher).launch  {
            repository.getSuperHero().collect { response ->
                when (response) {
                    is Status.Success -> response.data.results?.let { result ->
                        view.hideLoading()
                        view.updateUI(result = result)
                    }
                    is Status.Loading -> { view.showLoading() }
                    is Status.Fail -> { view.showError() }
                }
            }
        }
    }
}