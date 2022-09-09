package com.example.cooking_recipe.data.local.repository

import com.example.cooking_recipe.data.local.dao.FavoriteDao
import com.example.cooking_recipe.data.local.entity.FavoriteEntity
import kotlinx.coroutines.flow.Flow

class FavoriteLocalRepository(private val repository: FavoriteDao) {
    suspend fun saveFavorite(recipe: FavoriteEntity) = repository.saveFavorite(recipe)

    fun getSavedFavorites(): Flow<List<FavoriteEntity>> = repository.getSavedFavorites()

    fun isExistFavorite(name: String): Flow<Boolean> = repository.isExistFavorite(name)

    fun getFavoriteByName(name: String): Flow<FavoriteEntity?> = repository.getFavoriteByName(name)

    suspend fun deleteAllFavorites() = repository.deleteAllFavorites()

    suspend fun deleteFavorite(name: String) = repository.deleteFavorite(name)
}