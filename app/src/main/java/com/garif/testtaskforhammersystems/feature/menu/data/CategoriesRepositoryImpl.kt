package com.garif.testtaskforhammersystems.feature.menu.data

import com.garif.testtaskforhammersystems.feature.menu.data.api.Api
import com.garif.testtaskforhammersystems.feature.menu.data.api.mappers.CategoriesMapper
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category
import com.garif.testtaskforhammersystems.feature.menu.domain.repository.CategoriesRepository
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(
    private val api: Api,
    private val categoriesMapper: CategoriesMapper
) : CategoriesRepository {
    override suspend fun getCategories(): MutableList<Category> {
        return categoriesMapper.map(api.getCategories())
    }
}