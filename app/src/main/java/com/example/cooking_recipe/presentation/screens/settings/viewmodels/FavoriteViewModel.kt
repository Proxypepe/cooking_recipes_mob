package com.example.cooking_recipe.presentation.screens.settings.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cooking_recipe.data.local.repository.FavoriteLocalRepository

class SettingsViewModel(): ViewModel() {



}

class SettingsViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SettingsViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}