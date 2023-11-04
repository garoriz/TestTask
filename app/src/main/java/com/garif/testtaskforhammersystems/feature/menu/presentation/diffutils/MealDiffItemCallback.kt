package com.garif.testtaskforhammersystems.feature.menu.presentation.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Banner
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity

class MealDiffItemCallback : DiffUtil.ItemCallback<MealEntity>() {
    override fun areItemsTheSame(oldItem: MealEntity, newItem: MealEntity): Boolean =
        oldItem.idMeal == newItem.idMeal

    override fun areContentsTheSame(oldItem: MealEntity, newItem: MealEntity): Boolean {
        return oldItem == newItem
    }
}