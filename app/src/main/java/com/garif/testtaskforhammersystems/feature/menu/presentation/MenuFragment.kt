package com.garif.testtaskforhammersystems.feature.menu.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import com.garif.testtaskforhammersystems.R
import com.garif.testtaskforhammersystems.databinding.FragmentMenuBinding
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Banner
import com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.banner.BannerListAdapter
import com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.category.CategoryListAdapter
import com.garif.testtaskforhammersystems.utils.AppViewModelFactory
import javax.inject.Inject
import android.util.Log
import com.garif.testtaskforhammersystems.MainActivity
import com.google.android.material.snackbar.Snackbar

class MenuFragment : Fragment(R.layout.fragment_menu) {
    @Inject
    lateinit var factory: AppViewModelFactory
    private lateinit var binding: FragmentMenuBinding
    private var bannerListAdapter: BannerListAdapter? = null
    private var categoryListAdapter: CategoryListAdapter? = null
    private val viewModel: MenuViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity as MainActivity).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMenuBinding.bind(view)

        with(binding) {
            (activity as AppCompatActivity).setSupportActionBar(binding.toolbar)
            bannerListAdapter = BannerListAdapter()

            binding.banners.run {
                adapter = bannerListAdapter
            }

            bannerListAdapter?.submitList(
                mutableListOf(
                    Banner(R.drawable.banner_1),
                    Banner(R.drawable.banner_2),
                )
            )
        }

        initObservers()
        viewModel.onGetCategories()
    }

    private fun initObservers() {
        viewModel.categories.observe(viewLifecycleOwner) { it ->
            it.fold(onSuccess = {

                categoryListAdapter = CategoryListAdapter { clickedCategory ->
                    //getInfoAboutCity(clickedCity)
                }

                binding.categories.run {
                    adapter = categoryListAdapter
                }

                categoryListAdapter?.submitList(it)
            }, onFailure = {
                Log.e("e", it.message.toString())
            })
            viewModel.error.removeObservers(viewLifecycleOwner)
        }

        viewModel.error.observe(viewLifecycleOwner) {
            when (it) {
                is Exception -> {
                    showMessage(R.string.error)
                }
            }
        }
    }

    private fun showMessage(stringId: Int) {
        Snackbar.make(
            binding.root,
            stringId,
            Snackbar.LENGTH_LONG
        ).show()
    }
}