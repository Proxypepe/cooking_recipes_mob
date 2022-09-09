package com.example.cooking_recipe.presentation.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cooking_recipe.data.mappers.RecipeMapper
import com.example.cooking_recipe.presentation.navigation.NavigationRouter
import com.example.cooking_recipe.presentation.screens.components.RecipeCard
import com.example.cooking_recipe.presentation.screens.home.components.SearchLine
import com.example.cooking_recipe.presentation.screens.home.viewmodels.HomeViewModel


@ExperimentalComposeUiApi
@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel,
    navController: NavHostController
) {
    // #TODO check emptyList
    Column {
        SearchLine(
            onSearchAction = homeViewModel::search
        )
        LazyColumn(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(4) {
                RecipeCard(
                    recipeInfo = RecipeMapper.recipeDefault,
                    modifier = Modifier.padding(5.dp).clickable{
                        navController.navigate(NavigationRouter.Detailed.route)
                    },
                )
            }
        }
    }
}
