package com.example.cooking_recipe.presentation.screens.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.cooking_recipe.R
import com.example.cooking_recipe.presentation.screens.settings.components.OptionButton
import com.example.cooking_recipe.presentation.screens.settings.components.OptionSwitch
import com.example.cooking_recipe.presentation.screens.settings.viewmodels.SettingsViewModel


@Composable
fun SettingsScreen(settingsViewModel: SettingsViewModel) {
    Column {
        OptionButton(
            name = stringResource(R.string.clean_name),
            description = stringResource(R.string.clean_description),
            buttonName = stringResource(R.string.clean_button_name),
            onClick = settingsViewModel::clearCache,
        )
        Spacer(modifier = Modifier.height(5.dp))
        OptionSwitch(
            name = stringResource(R.string.change_theme_name),
            description = stringResource(R.string.change_theme_description),
            checked = settingsViewModel.isDark,
            onCheckedChange = {
                settingsViewModel.isDark = it
                settingsViewModel.changeTheme(it)
            }
        )
    }
}
