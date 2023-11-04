package com.garif.testtaskforhammersystems.feature.menu.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
    suspend fun getAll(): List<Category>
}