package com.example.cooking_recipe.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {
    @TypeConverter
    fun toList(value: List<String>): String {
        val gson = Gson()
        return gson.toJson(value)
    }

    @TypeConverter
    fun fromList(value: String): List<String> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson(value, type)
    }
}