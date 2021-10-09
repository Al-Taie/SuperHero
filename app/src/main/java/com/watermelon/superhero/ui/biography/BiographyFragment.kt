package com.watermelon.superhero.ui.biography

import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.watermelon.superhero.databinding.FragmentBiographyBinding
import com.watermelon.superhero.model.data.response.Hero
import com.watermelon.superhero.ui.base.BaseFragment


class BiographyFragment : BaseFragment<FragmentBiographyBinding>() {
    private val args: BiographyFragmentArgs by navArgs()

    override fun setup() {}
    override fun callBack() {
        val hero = args.currentHero
        binding.apply {
            heroFullName.text = hero.biography?.fullName
            heroName.text = hero.name
            biographyRecycler.adapter = BiographyAdapter(listOf(hero))
        }
        sharedElementEnterTransition = TransitionInflater.from(context)
            .inflateTransition(android.R.transition.move)

    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentBiographyBinding
        get() = FragmentBiographyBinding::inflate
}