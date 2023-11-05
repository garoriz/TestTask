package com.garif.testtaskforhammersystems.feature.menu.domain.entity

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryAndMeals(
    @Embedded
    val category: Category,
    @Relation(
        parentColumn = "name",
        entityColumn = "category"
    )
    val meals: List<MealEntity>
)
