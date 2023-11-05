package com.garif.testtaskforhammersystems.feature.menu.domain.usecase

import com.garif.testtaskforhammersystems.db.AppDatabase
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveMealsUseCase @Inject constructor(
    private val db: AppDatabase
) {
    suspend operator fun invoke(meals: List<MealEntity>) {
        return withContext(Dispatchers.IO) {
            db.mealDao().insertAll(meals)
        }
    }
}