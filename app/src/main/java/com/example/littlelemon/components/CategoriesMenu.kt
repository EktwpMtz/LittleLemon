package com.example.littlelemon.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.Green
import com.example.littlelemon.ui.theme.Highlight
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun CategoriesMenu(selectedCategory: String, changeCategory: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(text = "ORDER FOR DELIVERY!", style = MaterialTheme.typography.titleLarge)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
        ) {
            CategoryButton(
                selectedCategory = selectedCategory,
                category = "starters",
                onClick = changeCategory
            ) {
                Text(text = "Starters", style = MaterialTheme.typography.titleMedium)
            }
            CategoryButton(
                selectedCategory = selectedCategory,
                category = "mains",
                onClick = changeCategory
            ) {
                Text(text = "Mains", style = MaterialTheme.typography.titleMedium)
            }
            CategoryButton(
                selectedCategory = selectedCategory,
                category = "desserts",
                onClick = changeCategory
            ) {
                Text(text = "Desserts", style = MaterialTheme.typography.titleMedium)
            }
            CategoryButton(
                selectedCategory = selectedCategory,
                category = "drinks",
                onClick = changeCategory
            ) {
                Text(text = "Drinks", style = MaterialTheme.typography.titleMedium)
            }
        }
        Divider(
            color = Highlight, thickness = 3.dp, modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun CategoryButton(
    selectedCategory: String,
    category: String,
    onClick: (String) -> Unit,
    content: @Composable () -> Unit,
) {
    Button(
        onClick = { onClick(category) },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selectedCategory == category) Green else Highlight,
            contentColor = if (selectedCategory == category) Highlight else Green,
        ),
        contentPadding = PaddingValues(vertical = 4.dp, horizontal = 12.dp),
    ) {
        content()
    }
}

@Composable
@Preview(showBackground = true)
fun CategoriesMenuPreview() {
    var selectedCategory by remember {
        mutableStateOf("")
    }
    LittleLemonTheme {
        CategoriesMenu(selectedCategory) {
            selectedCategory = if (it == selectedCategory) "" else it
        }
    }
}