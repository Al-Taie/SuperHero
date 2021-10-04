package com.watermelon.superhero.presenter

import com.watermelon.superhero.model.repository.MainRepository
import com.watermelon.superhero.ui.interfaces.IMainView

class MainPresenter {
    private lateinit var view: IMainView
    private lateinit var repository: MainRepository

    fun passResponse() {

        val result = repository.makeRequest()
        view.onResponse(result = result)
    }

    fun onDestroy() {
        TODO("Not yet implemented")
    }
}