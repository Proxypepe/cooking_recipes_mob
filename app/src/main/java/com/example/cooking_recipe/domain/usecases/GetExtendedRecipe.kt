package com.example.cooking_recipe.domain.usecases

import com.example.cooking_recipe.domain.repositories.RecipeRepository

class GetExtendedRecipe(private val recipeRepository: RecipeRepository) {
    suspend operator fun invoke(recipe_name: String) = recipeRepository.getExtendedRecipe(recipe_name)
}