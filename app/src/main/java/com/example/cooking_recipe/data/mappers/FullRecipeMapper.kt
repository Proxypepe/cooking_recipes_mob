package com.example.cooking_recipe.data.mappers

import com.example.cooking_recipe.data.local.entity.FavoriteEntity
import com.example.cooking_recipe.data.remote.models.ExtendedRecipe

object FullRecipeMapper {

    fun toFavoriteEntity(extendedRecipe: ExtendedRecipe): FavoriteEntity =
        FavoriteEntity(
            cook = extendedRecipe.cook,
            description = extendedRecipe.description,
            file_name = extendedRecipe.file_name,
            ingredients = extendedRecipe.ingredients,
            name = extendedRecipe.name,
            prepare = extendedRecipe.prepare,
            steps = extendedRecipe.steps,
            tags = extendedRecipe.tags,
        )

    fun toExtendedRecipe(favorite: FavoriteEntity): ExtendedRecipe =
        ExtendedRecipe(
            cook = favorite.cook,
            description = favorite.description,
            file_name = favorite.file_name,
            ingredients = favorite.ingredients,
            name = favorite.name,
            prepare = favorite.prepare,
            steps = favorite.steps,
            tags = favorite.tags,
        )

    val favoriteEntityDefault = FavoriteEntity(
        cook = "4 hs",
        description = "some description",
        file_name = "beef",
        ingredients = listOf("first ing", "second ing", "third ing", "fourth ing"),
        name = "Beef",
        prepare = "15 min",
        steps = listOf("some first step", "some second step", "some third step"),
        tags = listOf("beef", "fire"),
    )

    val extendedRecipeDefault = toExtendedRecipe(favoriteEntityDefault)

}