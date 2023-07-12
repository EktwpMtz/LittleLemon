package com.example.littlelemon.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.AppHeader
import com.example.littlelemon.components.CustomTextField
import com.example.littlelemon.Onboarding
import com.example.littlelemon.ui.theme.DarkHighlight
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun ProfileScreen(navController: NavController) {
    val localContext = LocalContext.current
    val sharedPreferences = localContext.getSharedPreferences("LittleLemon", Context.MODE_PRIVATE)
    val firstname = sharedPreferences.getString("firstname", "") ?: ""
    val lastname = sharedPreferences.getString("lastname", "") ?: ""
    val email = sharedPreferences.getString("email", "") ?: ""
    Column(modifier = Modifier.fillMaxSize()) {
        AppHeader(navController)
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(modifier = Modifier.fillMaxHeight(0.1f))
            Text(text = "Profile information", style = MaterialTheme.typography.titleMedium)
            Column {
                CustomTextField(
                    label = "First name",
                    value = firstname,
                    onValueChange = { })
                CustomTextField(
                    label = "Last name",
                    value = lastname,
                    onValueChange = {  })
                CustomTextField(label = "Email", value = email, onValueChange = {  })
            }
            Button(
                onClick = {
                    sharedPreferences.edit().clear().apply()
                    navController.navigate(Onboarding.route) {
                        launchSingleTop = true
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = DarkHighlight,
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp)
            ) {
                Text(text = "Log out")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    val navController = rememberNavController()
    LittleLemonTheme {
        ProfileScreen(navController)
    }
}