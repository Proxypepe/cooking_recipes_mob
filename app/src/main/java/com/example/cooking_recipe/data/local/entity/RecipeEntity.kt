package com.example.cooking_recipe.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipe")
data class RecipeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cook: String,
    val file_name: String,
    val ingredients: Int,
    val name: String,
    val prepare: String,
    val steps: Int,
    val tags: List<String>
)
