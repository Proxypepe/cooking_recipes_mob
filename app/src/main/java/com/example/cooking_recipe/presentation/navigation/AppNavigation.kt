package com.example.cooking_recipe.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cooking_recipe.R
import com.example.cooking_recipe.presentation.navigation.components.BottomNavItem
import com.example.cooking_recipe.presentation.navigation.components.BottomNavigationBar
import com.example.cooking_recipe.presentation.screens.favorites.FavoritesScreen
import com.example.cooking_recipe.presentation.screens.home.HomeScreen
import com.example.cooking_recipe.presentation.screens.settings.SettingsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(

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
                HomeScreen()
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