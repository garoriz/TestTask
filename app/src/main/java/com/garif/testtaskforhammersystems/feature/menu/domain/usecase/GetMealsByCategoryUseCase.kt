package com.garif.testtaskforhammersystems.feature.menu.domain.usecase

import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity
import com.garif.testtaskforhammersystems.feature.menu.domain.repository.CategoriesRepository
import com.garif.testtaskforhammersystems.feature.menu.domain.repository.MealsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMealsByCategoryUseCase @Inject constructor(
    private val mealsRepository: MealsRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke(category: String): MutableList<MealEntity> {
        return withContext(dispatcher) {
            mealsRepository.getMealsByCategory(category)
        }
    }
}