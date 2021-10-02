package com.watermelon.superhero.ui.biography

import android.view.LayoutInflater
import android.view.ViewGroup
import com.watermelon.superhero.databinding.FragmentBiographyBinding
import com.watermelon.superhero.ui.base.BaseFragment


class BiographyFragment : BaseFragment<FragmentBiographyBinding>() {
    override fun setup() {}

    override fun callBack() {}

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentBiographyBinding
        get() = FragmentBiographyBinding::inflate

}