package com.watermelon.superhero.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.mig35.carousellayoutmanager.CarouselLayoutManager
import com.mig35.carousellayoutmanager.CarouselZoomPostLayoutListener
import com.watermelon.superhero.R
import com.watermelon.superhero.databinding.FragmentHomeBinding
import com.watermelon.superhero.model.data.response.Hero
import com.watermelon.superhero.presenter.HomePresenter
import com.watermelon.superhero.presenter.SearchPresenter
import com.watermelon.superhero.ui.base.BaseFragment
import com.watermelon.superhero.ui.interfaces.HomeListener
import com.watermelon.superhero.ui.search.SearchAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>(), HomeListener {
    private val presenter = HomePresenter()
    override fun setup() {


    }

    override fun onResume() {
        super.onResume()
        val adapter = HeroAdapter(presenter.getListFromMainRepository())
        adapter.listener = this
        binding.recyclerHero.adapter = adapter
        recyclerStyle()
    }

    override fun callBack() {
        binding.searchBar.setOnFocusChangeListener { _, isFocused ->
            if (isFocused) {
                val action = HomeFragmentDirections.actionHomeFragmentToSearchFragment()
                val extras = FragmentNavigatorExtras(
                   binding.searchBar to getString(R.string.search_transition),
                    binding.breakLine to getString(R.string.line_transition),
                    binding.clearTextImage to getString(R.string.clear_transition)
                )
                findNavController().navigate(action,extras)
            }
        }
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate



    override fun updateHomeUI(result: List<Hero>) {
        val adapter = HeroAdapter(result)
        adapter.listener = this
        binding.recyclerHero.adapter =adapter
        recyclerStyle()
        Log.i("main",adapter.toString())
    }

    override fun onItemClicked(imageView: ImageView, hero: Hero) {
        val action =
            HomeFragmentDirections.actionHomeFragmentToBiographyFragment(currentHero = hero)
        val extras = FragmentNavigatorExtras(
            imageView to getString(R.string.image_transition)
        )
        findNavController().navigate(action, extras)
    }

    private fun recyclerStyle() {
        binding.recyclerHero.run {
            this.layoutManager = CarouselLayoutManager(CarouselLayoutManager.HORIZONTAL).apply {
                setPostLayoutListener(CarouselZoomPostLayoutListener())
            }
            setHasFixedSize(true)
        }

    }
}