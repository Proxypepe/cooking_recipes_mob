package com.example.cooking_recipe.presentation.screens.settings.viewmodels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cooking_recipe.data.local.repository.FavoriteLocalRepository
import com.example.cooking_recipe.data.local.repository.RecipeLocalRepository
import com.example.cooking_recipe.domain.common.AppSettings
import kotlinx.coroutines.launch

class SettingsViewModel(
    private val dataStore: DataStore<AppSettings>,
    private val favoriteLocalRepository: FavoriteLocalRepository,
    private val recipeLocalRepository: RecipeLocalRepository
) : ViewModel() {

    var isDark by mutableStateOf(false)

    init {
        getTheme()
    }

    private fun getTheme() = viewModelScope.launch {
        dataStore.data.collect {
            isDark = it.isDark
        }
    }


    fun changeTheme(isDark: Boolean) = viewModelScope.launch {
        dataStore.updateData {
            it.copy(
                isDark = isDark
            )
        }
        Log.d("Theme", "Theme changed")
    }

    fun clearCache()  = viewModelScope.launch {
        Log.d("clear", "Cache")
        recipeLocalRepository.deleteAllRecipes()
    }
}

class SettingsViewModelFactory(
    private val dataStore: DataStore<AppSettings>,
    private val favoriteLocalRepository: FavoriteLocalRepository,
    private val recipeLocalRepository: RecipeLocalRepository

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SettingsViewModel(
                dataStore,
                favoriteLocalRepository,
                recipeLocalRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}