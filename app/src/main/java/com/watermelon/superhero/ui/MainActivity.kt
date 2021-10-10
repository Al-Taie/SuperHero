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
import com.watermelon.superhero.util.slideVisibility

class MainActivity : BaseActivity<ActivityMainBinding>(), IMainView {
    override val theme = R.style.Theme_SuperHero
    private lateinit var homeListener: HomeListener
    private val mainPresenter = HomePresenter()

    override fun setup() {
        mainPresenter.view = this
        mainPresenter.bindOnUI()
    }


    override fun callBack() {
        binding.retryButton.setOnClickListener {
            mainPresenter.bindOnUI()
        }
    }

    override val inflate: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun showLoading() {
        setLoadingAnimation()
    }

    override fun hideLoading() {
        setLoadingAnimation(visible = false)
    }

    override fun showError() {
        setLoadingAnimation(R.raw.no_connection, loop = 0)
    }

    override fun updateUI(result: List<Hero>) {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        navHostFragment?.let {
            homeListener = navHostFragment.childFragmentManager.fragments[0] as HomeFragment
            homeListener.updateHomeUI(result = result)
        }
    }

    private fun setLoadingAnimation(rawRes: Int = R.raw.loading,
        visible: Boolean = true, loop: Int = -1) {

        binding.apply {

            loading.apply {
                setAnimation(rawRes)
                repeatCount = loop
                playAnimation()
                slideVisibility(visible)
            }

            retryButton.slideVisibility(visible)
            fragmentContainer.slideVisibility(!visible)
        }
    }
}