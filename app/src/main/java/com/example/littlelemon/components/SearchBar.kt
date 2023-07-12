package com.example.littlelemon.components

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.littlelemon.ui.theme.LittleLemonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {
    OutlinedTextField(value = "", onValueChange = {}, leadingIcon = {
        Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search icon")
    })
}

@Composable
@Preview
fun SearchBarPreview() {
    LittleLemonTheme {
        SearchBar()
    }
}