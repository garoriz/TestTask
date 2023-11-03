package com.garif.testtaskforhammersystems.feature.menu.presentation.diffutils

import androidx.recyclerview.widget.DiffUtil
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Banner

class BannerDiffItemCallback : DiffUtil.ItemCallback<Banner>() {
    override fun areItemsTheSame(oldItem: Banner, newItem: Banner): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Banner, newItem: Banner): Boolean {
        return oldItem == newItem
    }
}