package com.example.cooking_recipe.presentation.screens.detailed.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cooking_recipe.ui.theme.ExtendedTheme
import com.example.cooking_recipe.ui.theme.PaddingSize

@Composable
fun CookingInfo(
    prepare: String,
    cooking: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.border(1.dp, ExtendedTheme.colors.borderColor)
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Prepare: $prepare",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(PaddingSize.Small.size)
            )
            Text(
                text = "Cooking: $cooking",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(PaddingSize.Small.size)
            )
        }
    }
}
