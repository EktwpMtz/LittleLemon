package com.example.littlelemon

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val client = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }
    private val dishRepository by lazy { DishRepository(this) }

    private suspend fun getMenu(): List<Dish> {
        val data: MenuNetworkdata = client.get(URL).body()
        return data.menu.map { it.toDishEntity() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sharedPreferences = this.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)
        val firstname = sharedPreferences.getString("firstname", "")
        val lastname = sharedPreferences.getString("lastname", "")
        val email = sharedPreferences.getString("email", "")
        val isLoggedIn =
            !(firstname.isNullOrBlank() || lastname.isNullOrBlank() || email.isNullOrBlank())
        setContent {
            val navController = rememberNavController()
            LittleLemonTheme {
                NavigationComposable(navController = navController, isLoggedIn = isLoggedIn)
            }
        }
        lifecycleScope.launch(Dispatchers.IO) {
            if (dishRepository.isEmpty()) {
                val menuItems = getMenu()
                dishRepository.setDishes(dishes = menuItems.toTypedArray())
            }
        }
    }

    companion object {
        const val URL =
            "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LittleLemonTheme {
        Greeting("Android")
    }
}