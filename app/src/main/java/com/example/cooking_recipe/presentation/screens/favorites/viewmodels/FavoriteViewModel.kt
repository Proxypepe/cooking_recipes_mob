package com.example.cooking_recipe.presentation.screens.favorites.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cooking_recipe.data.local.entity.FavoriteEntity
import com.example.cooking_recipe.data.local.repository.FavoriteLocalRepository
import com.example.cooking_recipe.data.mappers.FullRecipeMapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FavoriteViewModel(private val favoritesRepository: FavoriteLocalRepository): ViewModel() {

    private val _favorites = MutableStateFlow(listOf<FavoriteEntity>())
    val favorites = _favorites.asStateFlow()

    init {
        getFavorites()
    }

    private fun getFavorites() = viewModelScope.launch {
        favoritesRepository.getSavedFavorites().collect{
            _favorites.value = it
        }
    }


}

class FavoriteViewModelFactory(private val favoritesRepository: FavoriteLocalRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoriteViewModel(favoritesRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}