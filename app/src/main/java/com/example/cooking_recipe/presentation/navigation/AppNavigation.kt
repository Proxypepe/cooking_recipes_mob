package com.example.cooking_recipe.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cooking_recipe.presentation.navigation.components.AppBottomNavigationBar
import com.example.cooking_recipe.presentation.screens.detailed.DetailedScreen
import com.example.cooking_recipe.presentation.screens.favorites.FavoritesScreen
import com.example.cooking_recipe.presentation.screens.favorites.viewmodels.FavoriteViewModel
import com.example.cooking_recipe.presentation.screens.home.HomeScreen
import com.example.cooking_recipe.presentation.screens.home.viewmodels.HomeViewModel
import com.example.cooking_recipe.presentation.screens.settings.SettingsScreen
import com.example.cooking_recipe.presentation.screens.settings.viewmodels.SettingsViewModel

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalComposeUiApi::class
)
@Composable
fun AppNavigation(
    homeViewModel: HomeViewModel,
    favoriteViewModel: FavoriteViewModel,
    settingsViewModel: SettingsViewModel
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            AppBottomNavigationBar(navController)
        },
        ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = NavigationRouter.Detailed.route
        ) {
            composable(NavigationRouter.Home.route) {
                HomeScreen(
                    homeViewModel
                )
            }

            composable(NavigationRouter.Detailed.route) {
                DetailedScreen(
                    navController = navController
                )
            }

            composable(NavigationRouter.Favorite.route) {
                FavoritesScreen()
            }

            composable(NavigationRouter.Settings.route) {
                SettingsScreen(settingsViewModel)
            }

        }
    }
}
