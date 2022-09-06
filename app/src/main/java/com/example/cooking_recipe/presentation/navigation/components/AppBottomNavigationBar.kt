package com.example.cooking_recipe.presentation.navigation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.cooking_recipe.R
import com.example.cooking_recipe.presentation.navigation.NavigationRouter

@Composable
fun AppBottomNavigationBar(
    navController: NavHostController,
) {
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
}