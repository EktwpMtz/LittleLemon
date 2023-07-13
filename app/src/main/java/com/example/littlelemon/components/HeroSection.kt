package com.example.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littlelemon.R
import com.example.littlelemon.ui.theme.Highlight
import com.example.littlelemon.ui.theme.LittleLemonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroSection(searchPhrase: String, onChange: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(horizontal = 12.dp, vertical = 12.dp)
    ) {
        Text(
            text = "Little Lemon",
            style = MaterialTheme.typography.displayLarge,
            color = MaterialTheme.colorScheme.secondary,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .padding(end = 18.dp)
            ) {
                Text(
                    text = "Chicago",
                    style = MaterialTheme.typography.displayMedium,
                    color = Color.White
                )
                Text(
                    text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White,
                    modifier = Modifier.padding(top = 12.dp)
                )
            }
            Image(
                painter = painterResource(id = R.drawable.hero_image),
                contentDescription = "Presentation",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(24.dp)),
                contentScale = ContentScale.FillWidth
            )
        }
        OutlinedTextField(
            value = searchPhrase,
            onValueChange = onChange,
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Search, contentDescription = "Search icon")
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = "Enter search phrase", style = MaterialTheme.typography.bodyMedium)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(containerColor = Highlight),
            singleLine = true,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun HeroSectionPreview() {
    var searchPhrase by remember {
        mutableStateOf("")
    }
    LittleLemonTheme {
        HeroSection(searchPhrase) { searchPhrase = it }
    }
}