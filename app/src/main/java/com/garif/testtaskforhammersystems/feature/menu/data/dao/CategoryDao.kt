package com.garif.testtaskforhammersystems.feature.menu.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
    suspend fun getAll(): MutableList<Category>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(categories: List<Category>)
}