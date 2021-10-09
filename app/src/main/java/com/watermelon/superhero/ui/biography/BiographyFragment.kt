package com.watermelon.superhero.ui.biography

import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.watermelon.superhero.R
import com.watermelon.superhero.databinding.FragmentBiographyBinding
import com.watermelon.superhero.ui.base.BaseFragment
import kotlinx.coroutines.delay


class BiographyFragment : BaseFragment<FragmentBiographyBinding>() {
    private val args: BiographyFragmentArgs by navArgs()

    override fun setup() {}
    override fun callBack() {
        val imageUrl = if(args.currentImage != ""){
            args.currentImage
        }else{
            args.currentSearchImage
        }
        loadImage(imageUrl,binding.heroImage)
        sharedElementEnterTransition = TransitionInflater.from(context)
            .inflateTransition(android.R.transition.move)
    }

    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentBiographyBinding
        get() = FragmentBiographyBinding::inflate


    private fun loadImage(url: String, view: ImageView) {
        Glide.with(view.context).load(url)
            .placeholder(R.drawable.ic_baseline_downloading_24)
            .error(R.drawable.ic_baseline_error_outline_24)
            .into(view)
    }


}