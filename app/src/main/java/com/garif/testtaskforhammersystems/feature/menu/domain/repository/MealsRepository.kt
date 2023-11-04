package com.garif.testtaskforhammersystems.feature.menu.domain.repository

import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity

interface MealsRepository {
    suspend fun getMealsByCategory(category: String): MutableList<MealEntity>
}