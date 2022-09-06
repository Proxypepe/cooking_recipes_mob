package com.example.cooking_recipe.domain.common

import kotlinx.serialization.Serializable


@Serializable
data class AppSettings (
    val isDark: Boolean = false
)