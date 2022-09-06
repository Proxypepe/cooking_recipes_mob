package com.example.cooking_recipe.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite")
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val cook: String,
    val description: String,
    val file_name: String,
    val ingredients: List<String>,
    val name: String,
    val prepare: String,
    val steps: List<String>,
    val tags: List<String>
)
