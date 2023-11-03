package com.garif.testtaskforhammersystems.di.module

import com.garif.testtaskforhammersystems.feature.menu.data.CategoriesRepositoryImpl
import com.garif.testtaskforhammersystems.feature.menu.domain.repository.CategoriesRepository
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {
    @Binds
    fun categoriesRepository(
        impl: CategoriesRepositoryImpl
    ): CategoriesRepository
}