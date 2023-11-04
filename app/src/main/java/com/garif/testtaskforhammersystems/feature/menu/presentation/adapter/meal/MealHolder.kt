package com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.meal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.garif.testtaskforhammersystems.R
import com.garif.testtaskforhammersystems.databinding.ItemCategoryBinding
import com.garif.testtaskforhammersystems.databinding.MealItemBinding
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity
import com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.category.CategoryHolder

class MealHolder(
    private val binding: MealItemBinding,
) : RecyclerView.ViewHolder(binding.root) {
    private var meal: MealEntity? = null

    fun bind(item: MealEntity) {
        this.meal = item
        with(binding) {
            ivMeal.load(item.strMealThumb)
            tvName.text = item.strMeal
            tvDescription.text = tvDescription.resources.getString(R.string.meal_description)
            tvPrice.text = tvDescription.resources.getString(R.string.meal_price)
        }
    }

    companion object {

        fun create(
            parent: ViewGroup,
        ) = MealHolder(
            MealItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}