package com.watermelon.superhero.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import com.watermelon.superhero.databinding.FragmentSearchBinding
import com.watermelon.superhero.ui.base.BaseFragment

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun setup() {}

    override fun callBack() {}
}