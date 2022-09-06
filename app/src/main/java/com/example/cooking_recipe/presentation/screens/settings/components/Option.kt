package com.example.cooking_recipe.presentation.screens.settings.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Switch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.cooking_recipe.ui.theme.ExtendedTheme


@Composable
fun OptionButton(
    name: String,
    description: String,
    buttonName: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Option(
        name,
        description,
        modifier
    ) {
        Button(onClick = onClick) {
            Text(text = buttonName)
        }
    }
}

@Composable
fun OptionSwitch(
    name: String,
    description: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    var scopeChecked: Boolean by remember { mutableStateOf(checked) }
    Option(
        name,
        description,
        modifier
    ) {
        Switch(
            checked = scopeChecked,
            onCheckedChange = {
                scopeChecked = it
                onCheckedChange(it)
            },
            enabled = enabled
        )
    }
}


@Composable
fun Option(
    name: String,
    description: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    var extendedHint by remember { mutableStateOf(false) }
    val animatedSizeDp by animateDpAsState(targetValue = if (extendedHint) 25.dp else 0.dp)
    Column(
        modifier = modifier.background(ExtendedTheme.colors.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = name, modifier = Modifier.fillMaxWidth(0.7f))
            content()
            IconButton(onClick = {
                extendedHint = if (extendedHint)
                    !extendedHint
                else
                    !extendedHint
            }) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "info",
                )
            }
        }
        AnimatedVisibility(extendedHint) {
            Text(text = description, modifier = Modifier
                .height(animatedSizeDp)
                .padding(start = 5.dp, bottom = 2.dp))
        }
        Divider(
            thickness = 1.dp
        )
    }
}