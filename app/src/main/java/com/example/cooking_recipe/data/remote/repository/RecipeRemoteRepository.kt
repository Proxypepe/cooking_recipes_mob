package com.example.cooking_recipe.data.remote.repository

import com.example.cooking_recipe.data.remote.api.RecipeApi
import com.example.cooking_recipe.data.remote.models.ExtendedRecipe
import com.example.cooking_recipe.data.remote.models.Recipe
import retrofit2.Response

class RecipeRemoteRepository(private val recipeApi: RecipeApi) {
    suspend fun getRecipes(): Response<Iterable<Recipe>> = recipeApi.getRecipes()

    suspend fun getExtendedRecipe(recipe_name: String): Response<ExtendedRecipe> =
        recipeApi.getExtendedRecipe(recipe_name)
}