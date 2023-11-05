package com.garif.testtaskforhammersystems.feature.menu.data.api.mappers

import com.garif.testtaskforhammersystems.feature.menu.data.api.response.meals.MealsResponse
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity

class MealsMapper {
    fun map(response: MealsResponse, category: String): MutableList<MealEntity> {
        val meals = mutableListOf<MealEntity>()
        for (meal in response.meals) {
            meals.add(
                MealEntity(
                    idMeal = meal.idMeal,
                    strMeal = meal.strMeal,
                    strMealThumb = meal.strMealThumb,
                    category = category
                )
            )
        }
        return meals
    }

}