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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.Green
import com.example.littlelemon.ui.theme.Highlight
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun CategoriesMenu() {
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
            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    containerColor = Highlight,
                    contentColor = Green,
                ), contentPadding = PaddingValues(vertical = 4.dp, horizontal = 12.dp)
            ) {
                Text(text = "Starters", style = MaterialTheme.typography.titleMedium)
            }
            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    containerColor = Highlight,
                    contentColor = Green,
                ), contentPadding = PaddingValues(vertical = 4.dp, horizontal = 12.dp)
            ) {
                Text(text = "Mains", style = MaterialTheme.typography.titleMedium)
            }
            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    containerColor = Highlight,
                    contentColor = Green,
                ), contentPadding = PaddingValues(vertical = 4.dp, horizontal = 12.dp)
            ) {
                Text(text = "Desserts", style = MaterialTheme.typography.titleMedium)
            }
            Button(
                onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(
                    containerColor = Highlight,
                    contentColor = Green,
                ), contentPadding = PaddingValues(vertical = 4.dp, horizontal = 12.dp)
            ) {
                Text(text = "Drinks", style = MaterialTheme.typography.titleMedium)
            }
        }
        Divider(
            color = Highlight, thickness = 3.dp, modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CategoriesMenuPreview() {
    LittleLemonTheme {
        CategoriesMenu()
    }
}