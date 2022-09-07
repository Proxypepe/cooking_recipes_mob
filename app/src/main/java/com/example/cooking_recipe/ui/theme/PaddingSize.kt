package com.example.cooking_recipe.ui.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class PaddingSize(val size: Dp) {
    object Small : PaddingSize(5.dp)
    object Medium : PaddingSize(10.dp)
    object Large : PaddingSize(15.dp)
}
