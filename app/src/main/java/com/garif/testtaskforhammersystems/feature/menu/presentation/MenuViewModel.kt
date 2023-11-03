package com.garif.testtaskforhammersystems.feature.menu.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.garif.testtaskforhammersystems.feature.menu.domain.entity.Category
import com.garif.testtaskforhammersystems.feature.menu.domain.usecase.GetCategoriesUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {
    private var _categories: MutableLiveData<Result<MutableList<Category>>> = MutableLiveData()
    val categories: LiveData<Result<MutableList<Category>>> = _categories

    private var _error: MutableLiveData<Exception> = MutableLiveData()
    val error: LiveData<Exception> = _error

    fun onGetCategories() {
        viewModelScope.launch {
            try {
                val categories = getCategoriesUseCase()
                _categories.value = Result.success(categories)
            } catch (ex: Exception) {
                _categories.value = Result.failure(ex)
                _error.value = ex
            }
        }
    }
}