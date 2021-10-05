package com.watermelon.superhero.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.watermelon.superhero.databinding.FragmentHomeBinding
import com.watermelon.superhero.model.data.response.Hero
import com.watermelon.superhero.ui.base.BaseFragment
import com.watermelon.superhero.ui.interfaces.HomeListener

class HomeFragment : BaseFragment<FragmentHomeBinding>(), HomeListener {
    override fun setup() {}

    override fun callBack() {}

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun updateHomeUI(result: List<Hero>) {
        binding.recyclerHero.adapter = HeroAdapter(result)
    }
}