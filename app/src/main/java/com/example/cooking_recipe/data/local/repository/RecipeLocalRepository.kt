package com.example.cooking_recipe.data.local.repository

import com.example.cooking_recipe.data.local.dao.RecipeDao
import com.example.cooking_recipe.data.mappers.RecipeMapper
import com.example.cooking_recipe.data.remote.models.Recipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

class RecipeLocalRepository(private val recipeDao: RecipeDao) {
    suspend fun saveRecipe(recipe: Recipe) {
        val entity = RecipeMapper.toRecipeEntity(recipe)
        recipeDao.saveRecipe(entity)
    }

    suspend fun getSavedRecipe(): List<Recipe> {
        val recipes =  recipeDao.getSavedRecipe()
        val result = mutableListOf<Recipe>()
        recipes.collect {
            it.map { recipe ->
                result.add(RecipeMapper.toRecipe(recipe))
            }
        }
        return result
    }

    fun deleteAllRecipes() = recipeDao.deleteAllRecipes()
}