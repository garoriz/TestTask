package com.garif.testtaskforhammersystems.feature.menu.data.api

import com.garif.testtaskforhammersystems.feature.menu.data.api.response.categories.CategoriesResponse
import com.garif.testtaskforhammersystems.feature.menu.data.api.response.meals.MealsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("list.php?c=list")
    suspend fun getCategories(): CategoriesResponse

    @GET("filter.php")
    suspend fun getMealsByCategory(@Query("c") category: String): MealsResponse
}