package com.garif.testtaskforhammersystems.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.garif.testtaskforhammersystems.di.ViewModelKey
import com.garif.testtaskforhammersystems.feature.menu.presentation.MenuViewModel
import com.garif.testtaskforhammersystems.utils.AppViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun bindViewModelFactory(
        factory: AppViewModelFactory
    ): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    fun bindMenuViewModel(
        viewModel: MenuViewModel
    ): ViewModel
}