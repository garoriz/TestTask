package com.garif.testtaskforhammersystems.feature.menu.data.api.mappers

import com.garif.testtaskforhammersystems.feature.menu.data.api.response.meals.Meal
import com.garif.testtaskforhammersystems.feature.menu.data.api.response.meals.MealsResponse
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity

class MealsMapper {
    fun map(response: MealsResponse): MutableList<MealEntity> {
        return response.meals.map(this::map) as MutableList<MealEntity>
    }

    private fun map(meal: Meal): MealEntity = MealEntity(
        idMeal = meal.idMeal,
        strMeal = meal.strMeal,
        strMealThumb = meal.strMealThumb
    )
}