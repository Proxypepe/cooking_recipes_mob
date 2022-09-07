package com.example.cooking_recipe.presentation.screens.detailed.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.cooking_recipe.ui.theme.ExtendedTheme


// Rename component
@Composable
fun AdjustButton(
    servingValue: MutableState<Int>,
    modifier: Modifier = Modifier
) {
    val borderThickness = 2.dp
    Box(
        modifier = modifier
            .border(borderThickness, color = Color.Black, shape = RoundedCornerShape(5.dp))
            .size(105.dp, 40.dp)
            .background(ExtendedTheme.colors.background)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            IconButton(
                modifier = Modifier.fillMaxWidth(0.3f),
                onClick = {
                    servingValue.value++
                }) {
                Icon(
                    imageVector = Icons.Default.ArrowUpward,
                    contentDescription = "Add"
                )
            }
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(borderThickness)
            )

            Text(
                modifier = Modifier.fillMaxWidth(0.5f),
                text = "${servingValue.value}",
                overflow = TextOverflow.Clip,
                textAlign = TextAlign.Center
            )
            Divider(
                color = Color.Black,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(borderThickness)
            )

            IconButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    servingValue.value = if (servingValue.value == 1) 1 else servingValue.value - 1
                }) {
                Icon(
                    imageVector = Icons.Default.ArrowDownward,
                    contentDescription = "Sub"
                )
            }
        }
    }
}