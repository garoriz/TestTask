package com.garif.testtaskforhammersystems.feature.menu.domain.usecase

import com.garif.testtaskforhammersystems.db.AppDatabase
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMealsByCategoryInDbUseCase @Inject constructor(
    private val db: AppDatabase
) {
    suspend operator fun invoke(category: String): MutableList<MealEntity> {
        return withContext(Dispatchers.IO) {
            db.mealDao().getByCategory(category)
        }
    }
}