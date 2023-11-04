package com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.meal

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity
import com.garif.testtaskforhammersystems.feature.menu.presentation.diffutils.MealDiffItemCallback

class MealListAdapter() : ListAdapter<MealEntity, MealHolder>(MealDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealHolder =
        MealHolder.create(parent)

    override fun onBindViewHolder(holder: MealHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun submitList(list: MutableList<MealEntity>?) {
        super.submitList(if (list == null) null else ArrayList(list))
    }
}