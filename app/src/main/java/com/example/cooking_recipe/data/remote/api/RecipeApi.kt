package com.example.cooking_recipe.data.remote.api

import com.example.cooking_recipe.data.remote.models.ExtendedRecipe
import com.example.cooking_recipe.data.remote.models.Recipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RecipeApi {
    @GET(".")
    suspend fun getRecipes(): Result<Iterable<Recipe>>

    @GET("./{recipe_name}")
    suspend fun getExtendedRecipe(@Path("recipe_name") recipe_name: String): Result<ExtendedRecipe>
}
