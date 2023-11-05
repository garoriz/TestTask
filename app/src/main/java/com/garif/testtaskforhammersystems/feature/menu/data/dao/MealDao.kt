package com.garif.testtaskforhammersystems.feature.menu.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity

@Dao
interface MealDao {
    @Query("SELECT * FROM meal WHERE category = :category")
    suspend fun getByCategory(category: String): MutableList<MealEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(meals: List<MealEntity>)
}