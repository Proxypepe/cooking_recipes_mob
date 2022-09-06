package com.example.cooking_recipe.data.mappers

import com.example.cooking_recipe.data.local.entity.RecipeEntity
import com.example.cooking_recipe.data.remote.models.Recipe

object RecipeMapper {

    fun toRecipeEntity(recipe: Recipe): RecipeEntity {
        return RecipeEntity(
            cook = recipe.cook ,
            file_name = recipe.file_name ,
            ingredients = recipe.ingredients ,
            name = recipe.name ,
            prepare = recipe.prepare ,
            steps = recipe.steps ,
            tags = recipe.tags
        )
    }

    fun toRecipe(recipeEntity: RecipeEntity): Recipe {
        return Recipe(
            cook = recipeEntity.cook ,
            file_name = recipeEntity.file_name ,
            ingredients = recipeEntity.ingredients ,
            name = recipeEntity.name ,
            prepare = recipeEntity.prepare ,
            steps = recipeEntity.steps ,
            tags = recipeEntity.tags
        )
    }
}