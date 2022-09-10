package com.example.cooking_recipe.presentation.screens.detailed.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.cooking_recipe.ui.theme.ExtendedTheme
import com.example.cooking_recipe.ui.theme.PaddingSize


@Composable
fun IngredientsSection(
    ingredients: List<String>
    // #TODO (int) -> Unit adjust function
) {

    val servings = remember { mutableStateOf(1) }

    Card(
        backgroundColor = ExtendedTheme.colors.background,
        modifier = Modifier.fillMaxWidth(),
        elevation = ExtendedTheme.extendedTypography.standardElevation,
    ) {
        Column(
            modifier = Modifier.padding(PaddingSize.Small.size),
        ) {
            Text(
                text = "Ingredients",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(PaddingSize.Large.size)
            )
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AdjustButton(
                        servings
                    )
                    Spacer(modifier = Modifier.width(PaddingSize.Medium.size))
                    Button(
                        onClick = {
                            /*TODO*/
                        }
                    ) {
                        Text(text = "Adjust")
                    }
                }
                Text(text = "Servings")

                Spacer(
                    modifier = Modifier.height(PaddingSize.Small.size)
                )

                ingredients.map {
                    Ingredient(
                        it,
                        modifier = Modifier.padding(PaddingSize.Small.size)
                    )
                }
            }
        }
    }
}