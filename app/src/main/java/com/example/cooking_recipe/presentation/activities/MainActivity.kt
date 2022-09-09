package com.example.cooking_recipe.presentation.activities

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.datastore.dataStore
import com.example.cooking_recipe.domain.CookingRecipeApplication
import com.example.cooking_recipe.domain.common.AppSettings
import com.example.cooking_recipe.domain.common.AppSettingsSerializer
import com.example.cooking_recipe.presentation.navigation.AppNavigation
import com.example.cooking_recipe.presentation.screens.detailed.viewmodels.DetailedViewModel
import com.example.cooking_recipe.presentation.screens.detailed.viewmodels.DetailedViewModelFactory
import com.example.cooking_recipe.presentation.screens.favorites.viewmodels.FavoriteViewModel
import com.example.cooking_recipe.presentation.screens.favorites.viewmodels.FavoriteViewModelFactory
import com.example.cooking_recipe.presentation.screens.home.viewmodels.HomeViewModel
import com.example.cooking_recipe.presentation.screens.home.viewmodels.HomeViewModelFactory
import com.example.cooking_recipe.presentation.screens.settings.viewmodels.SettingsViewModel
import com.example.cooking_recipe.presentation.screens.settings.viewmodels.SettingsViewModelFactory
import com.example.cooking_recipe.ui.theme.Cooking_recipeTheme

val Context.dataStore by dataStore("app-settings.json", AppSettingsSerializer)

class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory(
            (application as CookingRecipeApplication).recipeRemoteRepository,
            (application as CookingRecipeApplication).recipeLocalRepository
        )
    }

    private val favoriteViewModel: FavoriteViewModel by viewModels {
        FavoriteViewModelFactory((application as CookingRecipeApplication).favoriteLocalRepository)
    }

    private val settingsViewModel: SettingsViewModel by viewModels {
        SettingsViewModelFactory(
            dataStore,
            (application as CookingRecipeApplication).favoriteLocalRepository,
            (application as CookingRecipeApplication).recipeLocalRepository
        )
    }

    private val detailedViewModel: DetailedViewModel by viewModels {
        DetailedViewModelFactory(
            (application as CookingRecipeApplication).favoriteLocalRepository
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            val appSettings = dataStore.data.collectAsState(
                initial = AppSettings()
            ).value

            Cooking_recipeTheme(darkTheme = appSettings.isDark) {
                AppNavigation(
                    homeViewModel = homeViewModel,
                    favoriteViewModel = favoriteViewModel,
                    settingsViewModel = settingsViewModel,
                    detailedViewModel = detailedViewModel
                )
            }
        }
    }
}
