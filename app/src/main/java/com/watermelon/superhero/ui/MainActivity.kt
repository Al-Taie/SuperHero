package com.watermelon.superhero.ui

import android.view.LayoutInflater
import com.watermelon.superhero.R
import com.watermelon.superhero.databinding.ActivityMainBinding
import com.watermelon.superhero.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_SuperHero

    override fun setup() {}

    override fun callBack() {}

    override val inflate: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate
}