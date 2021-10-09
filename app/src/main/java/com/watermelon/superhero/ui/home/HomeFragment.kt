package com.watermelon.superhero.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.watermelon.superhero.R
import com.watermelon.superhero.databinding.FragmentHomeBinding
import com.watermelon.superhero.model.data.response.Hero
import com.watermelon.superhero.ui.base.BaseFragment
import com.watermelon.superhero.ui.interfaces.HomeListener

class HomeFragment : BaseFragment<FragmentHomeBinding>(), HomeListener {
    override fun setup() {}

    override fun callBack() {
        binding.searchBar.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_searchFragment)
        }
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun updateHomeUI(result: List<Hero>) {
        binding.recyclerHero.adapter = HeroAdapter(result)
        recyclerStyle()
    }

    private fun recyclerStyle(){
        binding.recyclerHero.run {
            this.layoutManager = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL).apply {
                setPostLayoutListener(CarouselZoomPostLayoutListener())
            }
            setHasFixedSize(true)
        }

    }


}