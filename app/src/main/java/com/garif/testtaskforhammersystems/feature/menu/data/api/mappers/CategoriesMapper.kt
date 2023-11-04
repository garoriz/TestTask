package com.garif.testtaskforhammersystems.feature.menu.data.api.mappers

import com.garif.testtaskforhammersystems.feature.menu.data.api.response.categories.CategoriesResponse
import com.garif.testtaskforhammersystems.feature.menu.data.api.response.categories.Meal
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category

class CategoriesMapper {
    fun map(response: CategoriesResponse): MutableList<Category> {
        return response.meals.map(this::map) as MutableList<Category>
    }

    private fun map(meal: Meal): Category = Category(
        name = meal.strCategory
    )
}