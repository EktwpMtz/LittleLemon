package com.example.littlelemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.littlelemon.screens.HomeScreen
import com.example.littlelemon.screens.OnboardingScreen
import com.example.littlelemon.screens.ProfileScreen

@Composable
fun NavigationComposable(navController: NavHostController, isLoggedIn: Boolean) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) Home.route else Onboarding.route
    ) {
        composable(Home.route) {
            HomeScreen(navController)
        }
        composable(Profile.route) {
            ProfileScreen(navController)
        }
        composable(Onboarding.route) {
            OnboardingScreen(navController)
        }
    }
}