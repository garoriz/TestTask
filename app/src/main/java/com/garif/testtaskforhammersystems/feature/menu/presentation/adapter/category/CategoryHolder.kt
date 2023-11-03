package com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.garif.testtaskforhammersystems.databinding.ItemCategoryBinding
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category

class CategoryHolder(
    private val binding: ItemCategoryBinding,
    private val action: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    private var category: Category? = null

    init {
        itemView.setOnClickListener {
            category?.name?.also(action)
        }
    }

    fun bind(item: Category) {
        this.category = item
        with(binding) {
            btnCategory.text = item.name
        }
    }

    companion object {

        fun create(
            parent: ViewGroup,
            action: (String) -> Unit
        ) = CategoryHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), action
        )
    }
}