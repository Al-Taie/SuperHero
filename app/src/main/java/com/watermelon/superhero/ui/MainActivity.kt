package com.watermelon.superhero.ui

import android.view.LayoutInflater
import com.watermelon.superhero.R
import com.watermelon.superhero.databinding.ActivityMainBinding
import com.watermelon.superhero.presenter.MainPresenter
import com.watermelon.superhero.ui.base.BaseActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_SuperHero
    private lateinit var mainPresenter: MainPresenter
    override fun setup() {}

    override fun callBack() {}

    override fun onDestroy() {
        // Destroy View
        mainPresenter.onDestroy()
        super.onDestroy()
    }

    override val inflate: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate
}