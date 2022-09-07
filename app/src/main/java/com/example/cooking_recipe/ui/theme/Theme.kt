package com.example.cooking_recipe.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Color(0xFF161517)
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

data class ExtendedColors(
    val background: Color,
    val onBackground: Color,
    val borderColor: Color,
    val selectedColor: Color = Color(0xFF555555),
    val unSelectedColor: Color = Color(0xFF414141),
)

data class ExtendedTypography(
    val standardElevation: Dp = 5.dp
)


private val DarkExtendedColors by lazy {
    ExtendedColors(
        background = Color(0xFF19181B),
        onBackground = Color(0xFF001021),
        borderColor = Color(0xFF161517),
    )
}

private val LightExtendedColors by lazy {
    ExtendedColors(
        background = Color(0xFFFFFFFF),
        onBackground = Color(0xFF001021),
        borderColor = Color.Black
    )
}


val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        background = Color.Unspecified,
        onBackground = Color.Unspecified,
        borderColor = Color.Black,
    )
}

val LocalExtendedTypography = staticCompositionLocalOf {
    ExtendedTypography()
}

@Composable
fun Cooking_recipeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val extendedColors = if (darkTheme) {
        DarkExtendedColors
    } else {
        LightExtendedColors
    }

    val extendedTypography by lazy { ExtendedTypography() }

    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(
        LocalExtendedColors provides extendedColors,
        LocalExtendedTypography provides extendedTypography
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}

object ExtendedTheme {
    val colors: ExtendedColors
        @Composable
        @ReadOnlyComposable
        get() = LocalExtendedColors.current

    val extendedTypography: ExtendedTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalExtendedTypography.current
}