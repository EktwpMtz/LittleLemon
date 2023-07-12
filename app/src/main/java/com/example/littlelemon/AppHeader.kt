package com.example.littlelemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.ui.theme.LittleLemonTheme

@Composable
fun AppHeader(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(horizontal = 12.dp)
    ) {
        Box(modifier = Modifier.size(64.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon Logo",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
                .height(48.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .size(64.dp)
                .clickable {
                    navController.navigate(Profile.route) {
                        launchSingleTop = true
                    }
                }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun AppHeaderPreview() {
    val navController = rememberNavController()
    LittleLemonTheme() {
        AppHeader(navController)
    }
}