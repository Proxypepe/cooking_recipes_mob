package com.example.cooking_recipe.data.remote.models

data class Recipe(
    val cook: String,
    val file_name: String,
    val ingredients: Int,
    val name: String,
    val prepare: String,
    val steps: Int,
    val tags: List<String>
)