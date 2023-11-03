package com.garif.testtaskforhammersystems.di

import android.content.Context
import com.garif.testtaskforhammersystems.MainActivity
import com.garif.testtaskforhammersystems.di.module.AppModule
import com.garif.testtaskforhammersystems.di.module.NetModule
import com.garif.testtaskforhammersystems.di.module.RepoModule
import com.garif.testtaskforhammersystems.di.module.ViewModelModule
import com.garif.testtaskforhammersystems.feature.menu.presentation.MenuFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        RepoModule::class,
        ViewModelModule::class,
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(menuFragment: MenuFragment)
}