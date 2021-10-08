package com.watermelon.superhero.ui.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.watermelon.superhero.databinding.FragmentSearchBinding
import com.watermelon.superhero.model.data.response.Hero
import com.watermelon.superhero.presenter.ISearchPresenter
import com.watermelon.superhero.presenter.SearchPresenter
import com.watermelon.superhero.ui.base.BaseFragment

class SearchFragment : BaseFragment<FragmentSearchBinding>(),ISearchPresenter{
   private val presenter=SearchPresenter()

    override fun setup() {
        presenter.view=this
        presenter.getSearch()

    }

    override fun callBack() {}

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding
        get() = FragmentSearchBinding::inflate


    override  fun onSearchResult(result: List<Hero>) {

            Log.d("searchresult",result.toString())
    }

    override fun showLoading() {

    }

    override fun showError() {

    }

}