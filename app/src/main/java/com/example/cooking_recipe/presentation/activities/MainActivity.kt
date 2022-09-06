package com.example.cooking_recipe.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.cooking_recipe.domain.CookingRecipeApplication
import com.example.cooking_recipe.presentation.navigation.AppNavigation
import com.example.cooking_recipe.presentation.screens.favorites.viewmodels.FavoriteViewModel
import com.example.cooking_recipe.presentation.screens.favorites.viewmodels.FavoriteViewModelFactory
import com.example.cooking_recipe.presentation.screens.home.viewmodels.HomeViewModel
import com.example.cooking_recipe.presentation.screens.home.viewmodels.HomeViewModelFactory
import com.example.cooking_recipe.presentation.screens.settings.viewmodels.SettingsViewModel
import com.example.cooking_recipe.presentation.screens.settings.viewmodels.SettingsViewModelFactory
import com.example.cooking_recipe.ui.theme.Cooking_recipeTheme

class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(
            (application as CookingRecipeApplication).recipeRemoteRepository,
            (application as CookingRecipeApplication).recipeLocalRepository)
    }

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        FavoriteViewModelFactory((application as CookingRecipeApplication).favoriteLocalRepository)
    }

    private val settingsViewModel: SettingsViewModel by viewModels {
        SettingsViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            Cooking_recipeTheme {
                AppNavigation(
                    homeViewModel = homeViewModel,
                    favoriteViewModel = favoriteViewModel,
                    settingsViewModel = settingsViewModel
                )
            }
        }
    }
}
