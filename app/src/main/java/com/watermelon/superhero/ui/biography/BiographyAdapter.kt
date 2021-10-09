package com.watermelon.superhero.ui.biography

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.watermelon.superhero.databinding.ItemAppearanceBinding
import com.watermelon.superhero.databinding.ItemBiographyBinding
import com.watermelon.superhero.databinding.ItemGroupAffiliationBinding
import com.watermelon.superhero.databinding.ItemRelativesBinding
import com.watermelon.superhero.model.data.response.Hero


class BiographyAdapter(private val hero: Hero):
    RecyclerView.Adapter<BiographyAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when(viewType) {
            VIEW_TYPE_RELATIVES ->{
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemRelativesBinding.inflate(inflater, parent, false)
                return RelativesViewHolder(binding)
            }
            VIEW_TYPE_APPEARANCE ->{
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemAppearanceBinding.inflate(inflater, parent, false)
                return AppearanceViewHolder(binding)
            }
            VIEW_TYPE_GROUP_AFFILIATION ->{
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemGroupAffiliationBinding.inflate(inflater, parent, false)
                return GroupAffiliationViewHolder(binding)
            }
            VIEW_TYPE_BIOGRAPHY ->{
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemBiographyBinding.inflate(inflater, parent, false)
                return BiographyViewHolder(binding)
            }
        }

        return super.createViewHolder(parent,viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when(holder){
            is RelativesViewHolder -> {
                holder.binding.apply {
                    relativesText.text = hero.connections?.relatives
                }
            }
            is AppearanceViewHolder -> {
                holder.binding.apply {
                    heightText.text = hero.appearance?.height.toString()
                    weightText.text = hero.appearance?.weight.toString()
                    raceText.text = hero.appearance?.race
                    genderText.text = hero.appearance?.gender
                }
            }
            is GroupAffiliationViewHolder -> {
                holder.binding.apply {
                    groupAffiliationText.text = hero.connections?.groupAffiliation
                }
            }
            is BiographyViewHolder -> {
                holder.binding.apply {
                    aliasesText.text = hero.biography?.aliases.toString()
                    placeOfBirthText.text = hero.biography?.placeOfBirth
                }
            }
        }
    }

    override fun getItemCount() = ITEM_COUNT

    override fun getItemViewType(position: Int): Int {
        return when (position) {
          0 -> VIEW_TYPE_RELATIVES
          1 -> VIEW_TYPE_APPEARANCE
          2 -> VIEW_TYPE_GROUP_AFFILIATION
          else -> VIEW_TYPE_BIOGRAPHY
        }
    }

    abstract class BaseViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

    inner class RelativesViewHolder(val binding: ItemRelativesBinding) : BaseViewHolder(binding)
    inner class AppearanceViewHolder(val binding: ItemAppearanceBinding) : BaseViewHolder(binding)
    inner class GroupAffiliationViewHolder(val binding: ItemGroupAffiliationBinding) : BaseViewHolder(binding)
    inner class BiographyViewHolder(val binding: ItemBiographyBinding) : BaseViewHolder(binding)

    companion object {
        const val VIEW_TYPE_RELATIVES = 11
        const val VIEW_TYPE_APPEARANCE = 12
        const val VIEW_TYPE_GROUP_AFFILIATION = 13
        const val VIEW_TYPE_BIOGRAPHY = 14
        const val ITEM_COUNT = 4
    }
}