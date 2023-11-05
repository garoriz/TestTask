package com.garif.testtaskforhammersystems.feature.menu.data

import com.garif.testtaskforhammersystems.feature.menu.data.api.Api
import com.garif.testtaskforhammersystems.feature.menu.data.api.mappers.MealsMapper
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity
import com.garif.testtaskforhammersystems.feature.menu.domain.repository.MealsRepository
import javax.inject.Inject

class MealsRepositoryImpl @Inject constructor(
    private val api: Api,
    private val mealsMapper: MealsMapper
) : MealsRepository {
    override suspend fun getMealsByCategory(category: String): MutableList<MealEntity> {
        return mealsMapper.map(api.getMealsByCategory(category), category)
    }
}