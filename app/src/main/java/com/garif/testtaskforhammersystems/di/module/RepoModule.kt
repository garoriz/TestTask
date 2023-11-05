package com.garif.testtaskforhammersystems.di.module

import com.garif.testtaskforhammersystems.feature.menu.data.CategoriesRepositoryImpl
import com.garif.testtaskforhammersystems.feature.menu.data.MealsRepositoryImpl
import com.garif.testtaskforhammersystems.feature.menu.domain.repository.CategoriesRepository
import com.garif.testtaskforhammersystems.feature.menu.domain.repository.MealsRepository
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {
    @Binds
    fun categoriesRepository(
        impl: CategoriesRepositoryImpl
    ): CategoriesRepository

    @Binds
    fun mealsRepository(
        impl: MealsRepositoryImpl
    ): MealsRepository

}