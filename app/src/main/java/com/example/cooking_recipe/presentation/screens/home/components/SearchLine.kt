package com.example.cooking_recipe.presentation.screens.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@ExperimentalComposeUiApi
@Composable
fun SearchLine(
    onSearchAction: (query: String) -> Unit,
    modifier: Modifier = Modifier
) {

    var query by remember { mutableStateOf("")}
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        TextField(
            shape = RoundedCornerShape(10.dp),
            value = query,
            onValueChange = {
                query = it
            },
            placeholder = {
                Text(text = "Search")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            leadingIcon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search",
                )
            },
            trailingIcon = {
                IconButton(onClick = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }) {
                    Icon(
                        Icons.Filled.Close,
                        contentDescription = "Close",
                    )
                }
            },
            textStyle = TextStyle(
                fontSize = 15.sp
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onSearchAction(query)
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
            ),
        )
    }
}
