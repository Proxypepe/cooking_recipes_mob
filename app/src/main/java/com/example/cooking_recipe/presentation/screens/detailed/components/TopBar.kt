package com.example.cooking_recipe.presentation.screens.detailed.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavHostController
import com.example.cooking_recipe.ui.theme.ExtendedTheme


@Composable
fun TopBar(
    name: String,
    isFavorite: Boolean,
    onFavoriteChanged: () -> Unit,
    navController: NavHostController,
) {
    var isRed by remember { mutableStateOf(value = isFavorite) }
    val animatedColor by animateColorAsState(
        if (isRed) Color.Red else Color.Black,
        animationSpec = tween(
            durationMillis = 100,
            delayMillis = 100,
            easing = LinearEasing
        )
    )
    TopAppBar(
        backgroundColor = ExtendedTheme.colors.background,
        title = {
            Text(
                text = name,
                maxLines = 2,
                overflow = TextOverflow.Clip,
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigateUp()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
//                    tint =
                )
            }
        },
        actions = {
            IconButton(onClick = {
                onFavoriteChanged()
                isRed = !isRed
            }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "favorite",
                    tint = animatedColor
                )
            }
        }
    )
}
