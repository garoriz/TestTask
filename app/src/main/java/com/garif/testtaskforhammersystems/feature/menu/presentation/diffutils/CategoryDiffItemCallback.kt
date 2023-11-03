package com.garif.testtaskforhammersystems.feature.menu.presentation.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Banner
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category

class CategoryDiffItemCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean =
        oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}