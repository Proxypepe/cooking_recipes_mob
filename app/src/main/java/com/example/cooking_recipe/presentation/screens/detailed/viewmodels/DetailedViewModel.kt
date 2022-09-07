package com.example.cooking_recipe.presentation.screens.detailed.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class DetailedViewModel(): ViewModel() {

}


class DetailedViewModelModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailedViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DetailedViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}