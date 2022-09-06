package com.example.cooking_recipe.data.remote.models

data class ExtendedRecipe(
    val cook: String,
    val description: String,
    val file_name: String,
    val ingredients: List<String>,
    val name: String,
    val prepare: String,
    val steps: List<String>,
    val tags: List<String>
)