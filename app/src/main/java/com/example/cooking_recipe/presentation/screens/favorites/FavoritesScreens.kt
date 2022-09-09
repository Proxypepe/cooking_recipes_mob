package com.example.cooking_recipe.presentation.screens.favorites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.cooking_recipe.data.remote.models.Recipe
import com.example.cooking_recipe.presentation.navigation.NavigationRouter
import com.example.cooking_recipe.presentation.screens.components.RecipeCard
import com.example.cooking_recipe.presentation.screens.favorites.viewmodels.FavoriteViewModel
import com.example.cooking_recipe.ui.theme.PaddingSize


@Composable
fun FavoritesScreen(
    favoriteViewModel: FavoriteViewModel,
    navController: NavHostController
) {
    val favorites = favoriteViewModel.favorites.collectAsState()

    LazyColumn {
        items(favorites.value) {
            RecipeCard(
                recipeInfo = Recipe(
                    cook = it.cook,
                    file_name = it.file_name,
                    ingredients = it.ingredients.size,
                    name = it.name,
                    prepare = it.prepare,
                    steps = it.steps.size,
                    tags = it.tags,
                ),
                Modifier
                    .padding(PaddingSize.Small.size)
                    .clickable {
                        navController.navigate(NavigationRouter.Detailed.route)
                    },
            )
        }
    }
}