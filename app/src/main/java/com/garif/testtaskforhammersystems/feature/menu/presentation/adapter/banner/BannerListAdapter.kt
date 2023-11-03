package com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.banner

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Banner
import com.garif.testtaskforhammersystems.feature.menu.presentation.diffutils.BannerDiffItemCallback

class BannerListAdapter : ListAdapter<Banner, BannerHolder>(BannerDiffItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerHolder =
        BannerHolder.create(parent)

    override fun onBindViewHolder(holder: BannerHolder, position: Int) =
        holder.bind(getItem(position))

    override fun submitList(list: MutableList<Banner>?) {
        super.submitList(if (list == null) null else ArrayList(list))
    }
}