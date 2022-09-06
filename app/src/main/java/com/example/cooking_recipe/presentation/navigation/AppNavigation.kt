package com.example.cooking_recipe.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cooking_recipe.R
import com.example.cooking_recipe.presentation.navigation.components.BottomNavItem
import com.example.cooking_recipe.presentation.navigation.components.BottomNavigationBar
import com.example.cooking_recipe.presentation.screens.favorites.FavoritesScreen
import com.example.cooking_recipe.presentation.screens.favorites.viewmodels.FavoriteViewModel
import com.example.cooking_recipe.presentation.screens.home.HomeScreen
import com.example.cooking_recipe.presentation.screens.home.viewmodels.HomeViewModel
import com.example.cooking_recipe.presentation.screens.settings.SettingsScreen
import com.example.cooking_recipe.presentation.screens.settings.viewmodels.SettingsViewModel

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalComposeUiApi::class)
@Composable
fun AppNavigation(
    homeViewModel: HomeViewModel,
    favoriteViewModel: FavoriteViewModel,
    settingsViewModel: SettingsViewModel
){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = stringResource(R.string.home_name),
                        route = NavigationRouter.Home.route,
                        icon = Icons.Default.Home
                    ),
                    BottomNavItem(
                        name = stringResource(R.string.favorite_name),
                        route = NavigationRouter.Favorite.route,
                        icon = Icons.Default.Favorite
                    ),
                    BottomNavItem(
                        name = stringResource(R.string.settings_name),
                        route = NavigationRouter.Settings.route,
                        icon = Icons.Default.Settings
                    )
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        },


    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = NavigationRouter.Home.route)
        {
            composable(NavigationRouter.Home.route) {
                HomeScreen(
                    homeViewModel
                )
            }

            composable(NavigationRouter.Favorite.route) {
                FavoritesScreen()
            }

            composable(NavigationRouter.Settings.route) {
                SettingsScreen()
            }

        }
    }
}