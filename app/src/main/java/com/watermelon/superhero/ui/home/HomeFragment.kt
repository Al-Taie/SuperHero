package com.watermelon.superhero.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.watermelon.superhero.databinding.FragmentHomeBinding
import com.watermelon.superhero.ui.base.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun setup() {}

    override fun callBack() {}

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

}