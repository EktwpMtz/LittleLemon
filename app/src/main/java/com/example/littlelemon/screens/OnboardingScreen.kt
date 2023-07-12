package com.example.littlelemon.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.AppHeader
import com.example.littlelemon.Home
import com.example.littlelemon.Onboarding
import com.example.littlelemon.components.CustomTextField
import com.example.littlelemon.ui.theme.DarkHighlight
import com.example.littlelemon.ui.theme.Highlight
import com.example.littlelemon.ui.theme.LittleLemonTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(navController: NavHostController) {
    var name by remember { mutableStateOf(TextFieldValue("")) }
    var lastname by remember { mutableStateOf(TextFieldValue("")) }
    var email by remember { mutableStateOf(TextFieldValue("")) }
    val localContext = LocalContext.current
    Scaffold(topBar = {
        AppHeader(navController = navController)
    }, containerColor = Color.White) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Let's get to know you",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(vertical = 48.dp),
                    style = MaterialTheme.typography.titleLarge,
                    color = Highlight
                )
            }
            Column(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text = "Personal information",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 64.dp)
                )
                Column {
                    CustomTextField(label = "First name",
                        value = name,
                        onValueChange = { name = it })
                    CustomTextField(label = "Last name",
                        value = lastname,
                        onValueChange = { lastname = it })
                    CustomTextField(label = "Email",
                        value = email,
                        onValueChange = { email = it })
                }
                Button(
                    onClick = {
                        if (name.text.isBlank() || lastname.text.isBlank() || email.text.isBlank()) {
                            Toast.makeText(
                                localContext,
                                "Registration unsuccessful. Please enter all data.",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            val sharedPreferences = localContext.getSharedPreferences(
                                "LittleLemon", Context.MODE_PRIVATE
                            )
                            sharedPreferences.edit().putString("firstname", name.text)
                                .putString("lastname", lastname.text)
                                .putString("email", email.text).apply()
                            Toast.makeText(
                                localContext, "Registration successful!", Toast.LENGTH_SHORT
                            ).show()
                            navController.navigate(Home.route) {
                                popUpTo(Onboarding.route) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
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
                    Text(text = "Register")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    val navController = rememberNavController()
    LittleLemonTheme {
        OnboardingScreen(navController)
    }
}