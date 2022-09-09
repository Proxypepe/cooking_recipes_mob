package com.example.cooking_recipe.presentation.screens.detailed.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.cooking_recipe.ui.theme.PaddingSize

@Composable
fun StepsSection(
    steps: List<String>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Steps",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(PaddingSize.Large.size)
        )
        steps.mapIndexed { index, step ->
            Step(index, step)
        }
    }
}
