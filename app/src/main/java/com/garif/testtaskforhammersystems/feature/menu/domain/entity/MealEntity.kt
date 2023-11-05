package com.garif.testtaskforhammersystems.feature.menu.domain.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "meal",
    foreignKeys = [ForeignKey(
        entity = Category::class,
        parentColumns = arrayOf("name"),
        childColumns = arrayOf("category"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class MealEntity(
    @PrimaryKey
    val idMeal: String,
    val strMeal: String,
    val strMealThumb: String,
    val category: String
)
