package com.example.cooking_recipe.presentation.screens.detailed.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cooking_recipe.data.local.repository.FavoriteLocalRepository
import com.example.cooking_recipe.data.mappers.FullRecipeMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class DetailedViewModel(
    private val favoriteLocalRepository: FavoriteLocalRepository,
) : ViewModel() {
    var name: String = ""

    private var _isFavorite = MutableStateFlow(false)
    var isFavorite = _isFavorite.asStateFlow()


    private val _currentFullRecipe = MutableStateFlow(FullRecipeMapper.extendedRecipeDefault)
    val currentFullRecipe = _currentFullRecipe.asStateFlow()

    fun isExistFavorite() = viewModelScope.launch {
        favoriteLocalRepository.isExistFavorite(name).collect {
            _isFavorite.value = it
        }
    }

    fun onCheckedChanged() = viewModelScope.launch {
        if (_isFavorite.value)
            favoriteLocalRepository.deleteFavorite(
                name
            )
        else
            favoriteLocalRepository.saveFavorite(
                FullRecipeMapper.toFavoriteEntity(
                    _currentFullRecipe.value
                )
            )
    }
}


class DetailedViewModelFactory(
    private val favoriteLocalRepository: FavoriteLocalRepository,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailedViewModel(
                favoriteLocalRepository
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}