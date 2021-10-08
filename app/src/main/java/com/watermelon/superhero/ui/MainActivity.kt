package com.watermelon.superhero.ui

import android.view.LayoutInflater
import com.watermelon.superhero.R
import com.watermelon.superhero.databinding.ActivityMainBinding
import com.watermelon.superhero.model.data.response.Hero
import com.watermelon.superhero.presenter.HomePresenter
import com.watermelon.superhero.ui.base.BaseActivity
import com.watermelon.superhero.ui.home.HomeFragment
import com.watermelon.superhero.ui.interfaces.HomeListener
import com.watermelon.superhero.ui.interfaces.IMainView
import com.watermelon.superhero.ui.search.SearchFragment
import com.watermelon.superhero.util.slideVisibility

class MainActivity : BaseActivity<ActivityMainBinding>(), IMainView {
    override val theme = R.style.Theme_SuperHero
    private lateinit var homeListener: HomeListener
    private val mainPresenter = HomePresenter()


    override fun setup() {
        mainPresenter.view = this
        mainPresenter.bindOnUI()
    }

    override fun callBack() {}

    override val inflate: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun showLoading() {
        binding.apply {
            loading.apply {
                setAnimation(R.raw.loading)
                playAnimation()
                slideVisibility(true)
            }
            fragmentContainer.slideVisibility(false)
        }
    }

    override fun hideLoading() {
        binding.apply {
            loading.slideVisibility(false)
            fragmentContainer.slideVisibility(true)
        }
    }

    override fun showError() {
        binding.apply {
            loading.apply {
                setAnimation(R.raw.no_connection)
                playAnimation()
                slideVisibility(visibility = true)
            }
            fragmentContainer.slideVisibility(false)
        }
    }

    override fun updateUI(result: List<Hero>) {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        homeListener = navHostFragment?.childFragmentManager?.fragments?.get(0) as HomeFragment
        homeListener.updateHomeUI(result = result)

    }

}