package com.garif.testtaskforhammersystems.feature.menu.presentation

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.garif.testtaskforhammersystems.MainActivity
import com.garif.testtaskforhammersystems.R
import com.garif.testtaskforhammersystems.databinding.FragmentMenuBinding
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Banner
import com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.banner.BannerListAdapter
import com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.category.CategoryListAdapter
import com.garif.testtaskforhammersystems.feature.menu.presentation.adapter.meal.MealListAdapter
import com.garif.testtaskforhammersystems.utils.AppViewModelFactory
import com.google.android.material.snackbar.Snackbar
import javax.inject.Inject


class MenuFragment : Fragment(R.layout.fragment_menu) {
    @Inject
    lateinit var factory: AppViewModelFactory
    private lateinit var binding: FragmentMenuBinding
    private var bannerListAdapter: BannerListAdapter? = null
    private var categoryListAdapter: CategoryListAdapter? = null
    private var mealListAdapter: MealListAdapter? = null
    private val viewModel: MenuViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity as MainActivity).appComponent.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentMenuBinding.bind(view)

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

        initObservers()
        viewModel.onGetCategories(isNetworkAvailable())
    }

    private fun initObservers() {
        viewModel.categories.observe(viewLifecycleOwner) { it ->
            it.fold(onSuccess = {

                categoryListAdapter = CategoryListAdapter { clickedCategory ->
                    viewModel.onGetMealsByCategory(clickedCategory, isNetworkAvailable())
                }

                binding.categories.run {
                    adapter = categoryListAdapter
                }

                categoryListAdapter?.submitList(it)

                viewModel.onGetMealsByCategory(it[0].name, isNetworkAvailable())
            }, onFailure = {
                Log.e("e", it.message.toString())
            })
        }

        viewModel.meals.observe(viewLifecycleOwner) { it ->
            it.fold(onSuccess = {

                mealListAdapter = MealListAdapter()

                binding.meals.run {
                    adapter = mealListAdapter
                }

                mealListAdapter?.submitList(it)

            }, onFailure = {
                Log.e("e", it.message.toString())
            })
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

    private fun isNetworkAvailable(): Boolean {
        return try {
            val cm = requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            cm.getNetworkCapabilities(cm.activeNetwork)!!.hasCapability(NET_CAPABILITY_INTERNET)
        } catch (e: java.lang.Exception) {
            false
        }
    }
}