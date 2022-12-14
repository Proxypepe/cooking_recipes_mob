package com.example.cooking_recipe.presentation.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cooking_recipe.R
import com.example.cooking_recipe.data.mappers.RecipeMapper
import com.example.cooking_recipe.data.remote.models.Recipe
import com.example.cooking_recipe.presentation.navigation.NavigationRouter
import com.example.cooking_recipe.ui.theme.Cooking_recipeTheme
import com.example.cooking_recipe.ui.theme.ExtendedTheme
import com.example.cooking_recipe.ui.theme.PaddingSize


@Composable
fun RecipeCard(
    recipeInfo: Recipe,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        backgroundColor = ExtendedTheme.colors.background,
        elevation = ExtendedTheme.extendedTypography.standardElevation
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = modifier.padding(PaddingSize.Small.size)
        ) {
            Image(
                painterResource(R.drawable.ic_placeholder),
                contentDescription = "",
            )

            Column(
                modifier = Modifier
                    .padding(PaddingSize.Medium.size)
                    .fillMaxWidth(0.8f)
            ) {
                Text(text = "Name: ${recipeInfo.name}", overflow = TextOverflow.Clip)
                Text(text = "Prep: ${recipeInfo.prepare}")
                Text(text = "Cook: ${recipeInfo.cook}")
                Text(text = "Steps: ${recipeInfo.steps}")
                Text(text = "Ingredients: ${recipeInfo.ingredients}")
            }
            Column {
                recipeInfo.tags.map {
                    RecipeTag(
                        it,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }
        }
    }
}
