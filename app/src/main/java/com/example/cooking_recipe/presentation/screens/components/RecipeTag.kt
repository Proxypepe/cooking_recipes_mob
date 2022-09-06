package com.example.cooking_recipe.presentation.screens.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun RecipeTag(
    tag: String,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, color = Color.Black),
        modifier = modifier
    ){
        Text(text = tag , modifier = Modifier.padding(5.dp))
    }
}