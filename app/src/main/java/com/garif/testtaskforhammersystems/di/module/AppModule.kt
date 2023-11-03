package com.garif.testtaskforhammersystems.di.module

import com.garif.testtaskforhammersystems.feature.menu.data.api.mappers.CategoriesMapper
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
class AppModule {
    @Provides
    fun provideCategoriesMapper(): CategoriesMapper = CategoriesMapper()

    @Provides
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}