package com.example.cooking_recipe.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cooking_recipe.data.local.dao.FavoriteDao
import com.example.cooking_recipe.data.local.dao.RecipeDao
import com.example.cooking_recipe.data.local.entity.FavoriteEntity
import com.example.cooking_recipe.data.local.entity.RecipeEntity


@Database(entities = [RecipeEntity::class, FavoriteEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract class RecipeRoomDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
    abstract fun favoriteDao(): FavoriteDao

    companion object {

        @Volatile
        private var INSTANCE: RecipeRoomDatabase? = null

        fun getDatabase(
            context: Context
        ): RecipeRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RecipeRoomDatabase::class.java,
                    "recipes"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}