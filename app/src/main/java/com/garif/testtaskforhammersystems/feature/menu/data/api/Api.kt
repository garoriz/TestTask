package com.garif.testtaskforhammersystems.feature.menu.data.api

import com.garif.testtaskforhammersystems.feature.menu.data.api.response.CategoriesResponse
import retrofit2.http.GET

interface Api {
    @GET("1/list.php?c=list")
    suspend fun getCategories(): CategoriesResponse
}