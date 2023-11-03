package com.garif.testtaskforhammersystems

import android.app.Application
import com.garif.testtaskforhammersystems.di.AppComponent
import com.garif.testtaskforhammersystems.di.DaggerAppComponent
import com.garif.testtaskforhammersystems.di.module.AppModule
import com.garif.testtaskforhammersystems.di.module.NetModule

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule())
            .netModule(NetModule())
            .build()
    }
}