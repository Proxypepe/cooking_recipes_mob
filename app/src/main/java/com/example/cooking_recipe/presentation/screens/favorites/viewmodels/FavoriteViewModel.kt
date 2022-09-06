package com.example.cooking_recipe.presentation.screens.favorites.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cooking_recipe.data.local.repository.FavoriteLocalRepository

class FavoriteViewModel(private val favoritesRepository: FavoriteLocalRepository): ViewModel() {



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