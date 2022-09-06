package com.example.cooking_recipe.presentation.screens.home.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.cooking_recipe.data.local.repository.RecipeLocalRepository
import com.example.cooking_recipe.data.remote.models.Recipe
import com.example.cooking_recipe.data.remote.repository.RecipeRemoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class HomeViewModel(
    private val recipeRemoteRepository: RecipeRemoteRepository,
    private val recipeLocalRepository: RecipeLocalRepository
): ViewModel() {
    private val _recipes: MutableStateFlow<List<Recipe>> = MutableStateFlow(emptyList())
    private val _visibleRecipes: MutableStateFlow<List<Recipe>> = MutableStateFlow(emptyList())

    private val recipes = _visibleRecipes.asStateFlow()
    var loading: MutableStateFlow<Boolean> = MutableStateFlow(false)


//    init {
//        getRecipes()
//    }

    private fun getRecipes() = viewModelScope.launch {
        try {
            val response = recipeRemoteRepository.getRecipes()
            loading.value = true
            if (response.isSuccessful && response.body() != null) {
                _recipes.value = (response.body() as List<Recipe>?)!!
                _visibleRecipes.value = (response.body() as List<Recipe>?)!!
                loading.value = false
            }
        } catch(error: SocketTimeoutException) {
            loading.value = false
        }
    }

    fun search(query: String) {
        if (query.isNotBlank()) {
            _visibleRecipes.value = _recipes.value.filter{
                it.name.contains(query)
            }
        } else {
            _visibleRecipes.value = _recipes.value
        }
    }

}

class HomeViewModelFactory(
    private val recipeRemoteRepository: RecipeRemoteRepository,
    private val recipeRepository: RecipeLocalRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(recipeRemoteRepository, recipeRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}