package com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.garif.testtaskforhammersystems.R
import com.garif.testtaskforhammersystems.databinding.ItemCategoryBinding
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category

class CategoryHolder(
    private val binding: ItemCategoryBinding,
    private val action: (String) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    private var category: Category? = null

    fun bind(item: Category, selected: Boolean, position: Int, function: (Int) -> Unit) {
        this.category = item
        with(binding) {
            btnCategory.text = item.name
            btnCategory.isSelected = selected
            btnCategory.typeface =
                if (selected) {
                    ResourcesCompat.getFont(btnCategory.context, R.font.roboto_medium)
                } else {
                    ResourcesCompat.getFont(btnCategory.context, R.font.roboto)
                }
            btnCategory.setOnClickListener {
                function(position)
                category?.name?.also(action)
            }
        }
    }

    companion object {

        fun create(
            parent: ViewGroup,
            action: (String) -> Unit,
        ) = CategoryHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), action
        )
    }
}