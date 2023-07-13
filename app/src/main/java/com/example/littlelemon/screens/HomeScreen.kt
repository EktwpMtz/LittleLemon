package com.example.littlelemon.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.littlelemon.AppHeader
import com.example.littlelemon.Dish
import com.example.littlelemon.DishRepository
import com.example.littlelemon.components.CategoriesMenu
import com.example.littlelemon.components.HeroSection
import com.example.littlelemon.ui.theme.Highlight
import com.example.littlelemon.ui.theme.LittleLemonTheme

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val localContext = LocalContext.current
    val dishRepository by lazy { DishRepository(localContext) }
    var searchPhrase by remember {
        mutableStateOf("")
    }
    var selectedCategory by remember {
        mutableStateOf("")
    }
    Scaffold(topBar = {
        AppHeader(navController = navController)
    }, containerColor = Color.White) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padding)
        ) {
            val dishes by dishRepository.getAllDishes().observeAsState(listOf())
            var filtered = if (searchPhrase.isNotEmpty()) dishes.filter {
                it.title.contains(
                    searchPhrase,
                    true
                )
            } else dishes
            filtered = if (selectedCategory.isNotEmpty()) filtered.filter {
                it.category == selectedCategory
            } else filtered
            HeroSection(searchPhrase) { searchPhrase = it }
            CategoriesMenu(selectedCategory) {
                selectedCategory = if (selectedCategory == it) "" else it
            }
            Column {
                filtered.map { DishItem(it = it) }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DishItem(it: Dish) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(text = it.title, style = MaterialTheme.typography.titleSmall)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(bottom = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .fillMaxHeight()
                        .padding(end = 12.dp, top = 12.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = it.description,
                        maxLines = 3,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "$%.2f".format(it.price),
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    GlideImage(
                        model = it.image,
                        contentDescription = "Image of ${it.title}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            Divider(
                color = Highlight, thickness = 3.dp, modifier = Modifier
                    .fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    LittleLemonTheme {
        HomeScreen(navController)
    }
}