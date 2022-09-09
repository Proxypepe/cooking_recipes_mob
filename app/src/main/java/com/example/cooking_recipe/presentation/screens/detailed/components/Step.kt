package com.example.cooking_recipe.presentation.screens.detailed.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.cooking_recipe.ui.theme.ExtendedTheme
import com.example.cooking_recipe.ui.theme.PaddingSize


@Composable
fun Step(
    number: Int,
    description: String,
    modifier: Modifier = Modifier
) {
    val checkedValue = remember { mutableStateOf(false) }
    Column(
        modifier = modifier.fillMaxWidth().padding(PaddingSize.Medium.size),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = checkedValue.value,
                onCheckedChange = {
                    checkedValue.value = it
                })
            Text(
                modifier = Modifier.clickable {
                  checkedValue.value = !checkedValue.value
                },
                text = "Step $number",
                fontWeight = FontWeight.Bold,
                color = ExtendedTheme.colors.textColor
            )
        }
        Text(
            modifier = Modifier.fillMaxWidth().padding(start = PaddingSize.Large.size) ,
            text = description,
            color = ExtendedTheme.colors.textColor
        )
    }
}
