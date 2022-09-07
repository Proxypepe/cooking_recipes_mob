package com.example.cooking_recipe.presentation.screens.detailed.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cooking_recipe.R
import com.example.cooking_recipe.ui.theme.ExtendedTheme


@Composable
fun Header(
    prepare: String,
    cooking: String,
    description: String,
    fileName: String
) {
    Card(
        backgroundColor = ExtendedTheme.colors.background,
        elevation = ExtendedTheme.extendedTypography.standardElevation
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CookingInfo(prepare, cooking)
                Spacer(modifier = Modifier.width(5.dp))
                Image(
                    painterResource(R.drawable.ic_placeholder),
                    contentDescription = "",
                    modifier = Modifier.size(200.dp, 150.dp)
                )
            }
            Text(text = description)
            Spacer(modifier = Modifier.height(5.dp))
            Divider(thickness = 2.dp)
        }
    }
}
