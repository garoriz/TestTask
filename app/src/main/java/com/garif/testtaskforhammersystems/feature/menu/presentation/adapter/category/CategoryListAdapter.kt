package com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.category

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category
import com.garif.testtaskforhammersystems.feature.menu.presentation.diffutils.CategoryDiffItemCallback

class CategoryListAdapter(
    private val action: (String) -> Unit,
) : ListAdapter<Category, CategoryHolder>(CategoryDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder =
        CategoryHolder.create(parent, action)

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) =
        holder.bind(getItem(position))

    override fun submitList(list: MutableList<Category>?) {
        super.submitList(if (list == null) null else ArrayList(list))
    }
}