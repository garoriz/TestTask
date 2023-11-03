package com.garif.testtaskforhammersystems.feature.menu.domain.repository

import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category

interface CategoriesRepository {
    suspend fun getCategories(): MutableList<Category>
}