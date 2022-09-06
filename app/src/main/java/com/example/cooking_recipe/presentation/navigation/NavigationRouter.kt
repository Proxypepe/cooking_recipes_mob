package com.example.cooking_recipe.presentation.navigation

sealed class NavigationRouter(val route: String ) {
    object Home: NavigationRouter("home")
    object Settings: NavigationRouter("settings")
    object Favorite: NavigationRouter("favorite")
    object Detailed: NavigationRouter("detailed")
}
