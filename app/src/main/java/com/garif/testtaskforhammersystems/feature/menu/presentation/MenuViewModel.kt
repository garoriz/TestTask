package com.garif.testtaskforhammersystems.feature.menu.presentation

import android.content.Context
import android.net.ConnectivityManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.MealEntity
import com.garif.testtaskforhammersystems.feature.menu.domain.usecase.GetCategoriesInDbUseCase
import com.garif.testtaskforhammersystems.feature.menu.domain.usecase.GetCategoriesUseCase
import com.garif.testtaskforhammersystems.feature.menu.domain.usecase.GetMealsByCategoryUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getMealsByCategoryUseCase: GetMealsByCategoryUseCase,
    private val getCategoriesInDbUseCase: GetCategoriesInDbUseCase,
    //private val getMealsByCategoryInDbUseCase: GetMealsByCategoryInDbUseCase,
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
                        getCategoriesUseCase()
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
                val meals = getMealsByCategoryUseCase(category)
                _meals.value = Result.success(meals)
            } catch (ex: Exception) {
                _meals.value = Result.failure(ex)
                _error.value = ex
            }
        }
    }
}