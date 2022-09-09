package com.example.cooking_recipe.presentation.screens.detailed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.cooking_recipe.data.mappers.FullRecipeMapper
import com.example.cooking_recipe.presentation.screens.detailed.components.Header
import com.example.cooking_recipe.presentation.screens.detailed.components.IngredientsSection
import com.example.cooking_recipe.presentation.screens.detailed.components.StepsSection
import com.example.cooking_recipe.presentation.screens.detailed.components.TopBar
import com.example.cooking_recipe.ui.theme.PaddingSize


@Composable
fun DetailedScreen(
    navController: NavHostController,
) {
    // get FullRecipe

    val mockFullRecipe = FullRecipeMapper.extendedRecipeDefault
    with(mockFullRecipe) {
        Scaffold(
            backgroundColor = MaterialTheme.colorScheme.background,
            topBar = {
                TopBar(
                    name = name,
                    isFavorite = false,
                    onFavoriteChanged = {},
                    navController = navController
                )
            }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                item {
                    Header(
                        prepare = prepare,
                        cooking = cook,
                        description = description,
                        fileName = file_name,
                    )
                    Spacer(modifier = Modifier.height(PaddingSize.Small.size))
                }

                item {
                    IngredientsSection(
                        ingredients = ingredients
                    )
                    Spacer(modifier = Modifier.height(PaddingSize.Small.size))
                }

                item {
                    StepsSection(
                        steps = steps,
                    )
                }
            }
        }
    }
}


