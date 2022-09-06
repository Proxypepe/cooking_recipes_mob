package com.example.cooking_recipe.domain

import android.app.Application
import com.example.cooking_recipe.data.local.RecipeRoomDatabase
import com.example.cooking_recipe.data.local.repository.FavoriteLocalRepository
import com.example.cooking_recipe.data.local.repository.RecipeLocalRepository
import com.example.cooking_recipe.data.remote.RetrofitFactory
import com.example.cooking_recipe.data.remote.api.RecipeApi
import com.example.cooking_recipe.data.remote.repository.RecipeRemoteRepository

class CookingRecipeApplication: Application() {

    private val database by lazy { RecipeRoomDatabase.getDatabase(this)}
    val favoriteLocalRepository by lazy { FavoriteLocalRepository(database.favoriteDao()) }
    val recipeLocalRepository by lazy { RecipeLocalRepository(database.recipeDao()) }


    private val recipeApi by lazy { RetrofitFactory.getInstance<RecipeApi>("http://10.0.2.2:8000/api/v1/recipes/")}
    val recipeRemoteRepository by lazy { RecipeRemoteRepository(recipeApi) }
}