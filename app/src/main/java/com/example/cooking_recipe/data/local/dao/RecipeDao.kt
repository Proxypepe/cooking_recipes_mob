package com.example.cooking_recipe.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cooking_recipe.data.local.entity.RecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveRecipe(recipe: RecipeEntity)

    @Query("SELECT * FROM recipe")
    fun getSavedRecipe(): Flow<List<RecipeEntity>>

    @Query("DELETE FROM recipe")
    suspend fun deleteAllRecipes()

}