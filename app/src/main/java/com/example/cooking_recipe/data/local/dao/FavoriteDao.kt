package com.example.cooking_recipe.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cooking_recipe.data.local.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavorite(recipe: FavoriteEntity)

    @Query("SELECT * FROM favorite")
    fun getSavedFavorites(): Flow<List<FavoriteEntity>>

    @Query("DELETE FROM favorite")
    fun deleteAllFavorites()

    @Delete
    suspend fun deleteFavorite(recipe: FavoriteEntity)
}