package com.watermelon.superhero.ui.biography

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.watermelon.superhero.R
import com.watermelon.superhero.databinding.ItemAppearanceBinding
import com.watermelon.superhero.databinding.ItemBiographyBinding
import com.watermelon.superhero.databinding.ItemGroupAffiliationBinding
import com.watermelon.superhero.databinding.ItemRelativesBinding
import com.watermelon.superhero.model.data.response.Hero


class BiographyAdapter(private val list: List<Hero>):
    RecyclerView.Adapter<BiographyAdapter.BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        when(viewType) {
            VIEW_TYPE_RELATIVES ->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_relatives, parent,false)
                return RelativesViewHolder(view)
            }
            VIEW_TYPE_APPEARANCE ->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_appearance, parent,false)
                return AppearanceViewHolder(view)
            }
            VIEW_TYPE_GROUP_AFFILIATION ->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_group_affiliation, parent,false)
                return GroupAffiliationViewHolder(view)
            }
            VIEW_TYPE_BIOGRAPHY ->{
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_biography, parent,false)
                return BiographyViewHolder(view)
            }
        }

        return super.createViewHolder(parent,viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val currentCard = list[position]
        when(holder){
            is RelativesViewHolder -> {
                holder.binding.apply {
                    relativesText.text = currentCard.connections?.relatives
                }
            }
            is AppearanceViewHolder -> {
                holder.binding.apply {
                    heightText.text = currentCard.appearance?.height.toString()
                    weightText.text = currentCard.appearance?.weight.toString()
                    raceText.text = currentCard.appearance?.race
                    genderText.text = currentCard.appearance?.gender
                }
            }
            is GroupAffiliationViewHolder -> {
                holder.binding.apply {
                    groupAffiliationText.text = currentCard.connections?.groupAffiliation
                }
            }
            is BiographyViewHolder -> {
                holder.binding.apply {
                    aliasesText.text = currentCard.biography?.aliases.toString()
                    placeOfBirthText.text = currentCard.biography?.placeOfBirth
                }
            }
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int {
        return when (position) {
          0 -> VIEW_TYPE_RELATIVES
          1 -> VIEW_TYPE_APPEARANCE
          2 -> VIEW_TYPE_GROUP_AFFILIATION
          else -> VIEW_TYPE_BIOGRAPHY
        }
    }

    abstract class BaseViewHolder(viewItem: View) : RecyclerView.ViewHolder(viewItem)

    class RelativesViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
        val binding = ItemRelativesBinding.bind(viewItem)
    }
    class AppearanceViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
        val binding = ItemAppearanceBinding.bind(viewItem)
    }
    class GroupAffiliationViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
        val binding = ItemGroupAffiliationBinding.bind(viewItem)
    }
    class BiographyViewHolder(viewItem: View) : BaseViewHolder(viewItem) {
        val binding = ItemBiographyBinding.bind(viewItem)
    }

    companion object {
        const val VIEW_TYPE_RELATIVES = 11
        const val VIEW_TYPE_APPEARANCE = 12
        const val VIEW_TYPE_GROUP_AFFILIATION = 13
        const val VIEW_TYPE_BIOGRAPHY = 14
    }
}