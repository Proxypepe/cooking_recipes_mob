package com.example.cooking_recipe.data.remote.repository

import com.example.cooking_recipe.data.remote.api.RecipeApi
import com.example.cooking_recipe.data.remote.models.ExtendedRecipe
import com.example.cooking_recipe.data.remote.models.Recipe

class RecipeRemoteRepository(private val recipeApi: RecipeApi) {
    suspend fun getRecipes(): Result<Iterable<Recipe>> = recipeApi.getRecipes()

    suspend fun getExtendedRecipe(recipe_name: String): Result<ExtendedRecipe> =
        recipeApi.getExtendedRecipe(recipe_name)
}