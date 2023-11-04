package com.garif.testtaskforhammersystems

import android.app.Application
import com.garif.testtaskforhammersystems.di.AppComponent
import com.garif.testtaskforhammersystems.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}