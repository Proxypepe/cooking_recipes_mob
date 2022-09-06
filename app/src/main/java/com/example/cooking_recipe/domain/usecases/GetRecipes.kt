package com.example.cooking_recipe.domain.usecases

import com.example.cooking_recipe.domain.repositories.RecipeRepository

class GetRecipes(private val recipeRepository: RecipeRepository) {
    suspend operator fun invoke() = recipeRepository.getRecipes()
}