package com.example.cooking_recipe.data.local.dao

import androidx.room.*
import com.example.cooking_recipe.data.local.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveFavorite(recipe: FavoriteEntity)

    @Query("SELECT * FROM favorite")
    fun getSavedFavorites(): Flow<List<FavoriteEntity>>

    @Query("SELECT * FROM favorite WHERE name=:name")
    fun getFavoriteByName(name: String): Flow<FavoriteEntity?>

    @Query("DELETE FROM favorite")
    fun deleteAllFavorites()

    @Query("SELECT EXISTS(SELECT * FROM favorite WHERE name = :name)")
    fun isExistFavorite(name: String): Flow<Boolean>

    @Query("DELETE FROM favorite WHERE name = :name")
    fun deleteFavorite(name: String)
}