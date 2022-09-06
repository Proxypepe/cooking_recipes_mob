package com.example.cooking_recipe.data.local

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun fromList(value: List<String>): String {
        return value.joinToString { "," }
    }

    @TypeConverter
    fun toList(value: String): List<String> {
        return value.split(",")
    }
}