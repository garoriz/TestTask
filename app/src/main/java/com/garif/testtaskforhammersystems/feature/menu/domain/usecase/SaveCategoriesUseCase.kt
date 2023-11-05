package com.garif.testtaskforhammersystems.feature.menu.domain.usecase

import com.garif.testtaskforhammersystems.db.AppDatabase
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SaveCategoriesUseCase @Inject constructor(
    private val db: AppDatabase
) {
    suspend operator fun invoke(categories: List<Category>) {
        return withContext(Dispatchers.IO) {
            db.categoryDao().insertAll(categories)
        }
    }
}