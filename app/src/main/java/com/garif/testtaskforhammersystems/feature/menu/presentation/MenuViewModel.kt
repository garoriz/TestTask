package com.garif.testtaskforhammersystems.feature.menu.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity
import com.garif.testtaskforhammersystems.feature.menu.domain.usecase.GetCategoriesInDbUseCase
import com.garif.testtaskforhammersystems.feature.menu.domain.usecase.GetCategoriesUseCase
import com.garif.testtaskforhammersystems.feature.menu.domain.usecase.GetMealsByCategoryInDbUseCase
import com.garif.testtaskforhammersystems.feature.menu.domain.usecase.GetMealsByCategoryUseCase
import com.garif.testtaskforhammersystems.feature.menu.domain.usecase.SaveCategoriesUseCase
import com.garif.testtaskforhammersystems.feature.menu.domain.usecase.SaveMealsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getMealsByCategoryUseCase: GetMealsByCategoryUseCase,
    private val getCategoriesInDbUseCase: GetCategoriesInDbUseCase,
    private val saveCategoriesUseCase: SaveCategoriesUseCase,
    private val saveMealsUseCase: SaveMealsUseCase,
    private val getMealsByCategoryInDbUseCase: GetMealsByCategoryInDbUseCase
) : ViewModel() {
    private var _categories: MutableLiveData<Result<MutableList<Category>>> = MutableLiveData()
    val categories: LiveData<Result<MutableList<Category>>> = _categories

    private var _meals: MutableLiveData<Result<MutableList<MealEntity>>> = MutableLiveData()
    val meals: LiveData<Result<MutableList<MealEntity>>> = _meals

    private var _error: MutableLiveData<Exception> = MutableLiveData()
    val error: LiveData<Exception> = _error

    fun onGetCategories(isNetworkAvailable: Boolean) {
        viewModelScope.launch {
            try {
                val categories =
                    if (isNetworkAvailable) {
                        val categories = getCategoriesUseCase()
                        saveCategoriesUseCase(categories)
                        categories
                    } else {
                        getCategoriesInDbUseCase()
                    }
                _categories.value = Result.success(categories)
            } catch (ex: Exception) {
                _categories.value = Result.failure(ex)
                _error.value = ex
            }
        }
    }

    fun onGetMealsByCategory(category: String, isNetworkAvailable: Boolean) {
        viewModelScope.launch {
            try {
                val meals =
                    if (isNetworkAvailable) {
                        val meals = getMealsByCategoryUseCase(category)
                        saveMealsUseCase(meals)
                        meals
                    } else {
                        getMealsByCategoryInDbUseCase(category)
                    }
                _meals.value = Result.success(meals)
            } catch (ex: Exception) {
                _meals.value = Result.failure(ex)
                _error.value = ex
            }
        }
    }
}