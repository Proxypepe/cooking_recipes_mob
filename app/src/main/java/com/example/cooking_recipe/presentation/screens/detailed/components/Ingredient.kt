package com.example.cooking_recipe.presentation.screens.detailed.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow


@Composable
fun Ingredient(
    ingredient: String,
    modifier: Modifier = Modifier
) {

    var checkState by remember { mutableStateOf(false) }

    Card(
        backgroundColor = MaterialTheme.colorScheme.background,
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                checkState = !checkState
            },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                modifier = modifier.fillMaxWidth(0.1f),
                checked = checkState,
                onCheckedChange = {
                    checkState = it
                }
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = ingredient,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Visible
            )
        }
    }
}
