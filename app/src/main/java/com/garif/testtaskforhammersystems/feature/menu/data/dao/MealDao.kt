package com.garif.testtaskforhammersystems.feature.menu.data.dao

import androidx.room.Query
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity

interface MealDao {
    @Query("SELECT * FROM meal")
    suspend fun get(): MealEntity?
}