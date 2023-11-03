package com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.banner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.garif.testtaskforhammersystems.databinding.ItemBannerBinding
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Banner

class BannerHolder(
    private val binding: ItemBannerBinding
) : RecyclerView.ViewHolder(binding.root) {
    private var banner: Banner? = null

    fun bind(item: Banner) {
        this.banner = item
        with(binding) {
            ivBanner.setImageResource(item.id)
        }
    }

    companion object {

        fun create(
            parent: ViewGroup,
        ) = BannerHolder(
            ItemBannerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}