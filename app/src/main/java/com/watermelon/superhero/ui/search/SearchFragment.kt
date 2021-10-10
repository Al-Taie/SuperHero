package com.watermelon.superhero.ui.search

import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.watermelon.superhero.R
import com.watermelon.superhero.databinding.FragmentSearchBinding
import com.watermelon.superhero.model.data.response.Hero
import com.watermelon.superhero.presenter.ISearchPresenter
import com.watermelon.superhero.presenter.SearchPresenter
import com.watermelon.superhero.ui.base.BaseFragment
import com.watermelon.superhero.util.slideVisibility
import kotlinx.coroutines.FlowPreview

@FlowPreview
class SearchFragment : BaseFragment<FragmentSearchBinding>(), ISearchPresenter {
    private val presenter = SearchPresenter()

    override fun setup() {
        presenter.view = this
        binding.searchBar.apply {
            doOnTextChanged { text, _, _, _ ->
                presenter.getSearch(text.toString())
            }
            requestFocus()
        }
    }

    override fun callBack() {
        sharedElementEnterTransition = TransitionInflater.from(context)
            .inflateTransition(android.R.transition.move)

        binding.apply {
            clearTextImage.setOnClickListener {
                searchBar.text.clear()
            }
        }
    }


    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate

    override fun onSearchResult(result: List<Hero>) {
        binding.searchRecyclerView.adapter = SearchAdapter(result)
    }

    override fun showLoading() {
        setLoadingAnimation()
    }

    override fun hideLoading() {
        setLoadingAnimation(visible = false)
    }

    override fun showError() {
        setLoadingAnimation(R.raw.no_connection, loop = 0)
    }

    private fun setLoadingAnimation(rawRes: Int = R.raw.loading,
                                    visible: Boolean = true, loop: Int = -1) {
        binding.loading.apply {
            setAnimation(rawRes)
            repeatCount = loop
            playAnimation()
            slideVisibility(visible)
        }
        binding.searchRecyclerView.slideVisibility(!visible)
    }
}