package com.garif.testtaskforhammersystems.di

import android.content.Context
import com.garif.testtaskforhammersystems.MainActivity
import com.garif.testtaskforhammersystems.di.module.AppModule
import com.garif.testtaskforhammersystems.di.module.DbModule
import com.garif.testtaskforhammersystems.di.module.NetModule
import com.garif.testtaskforhammersystems.di.module.RepoModule
import com.garif.testtaskforhammersystems.di.module.ViewModelModule
import com.garif.testtaskforhammersystems.feature.menu.presentation.MenuFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DbModule::class,
        AppModule::class,
        NetModule::class,
        RepoModule::class,
        ViewModelModule::class,
    ]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun inject(menuFragment: MenuFragment)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}