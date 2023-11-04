package com.garif.testtaskforhammersystems.di.module

import android.content.Context
import com.garif.testtaskforhammersystems.db.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun provideDb(context: Context): AppDatabase = AppDatabase(context)
}