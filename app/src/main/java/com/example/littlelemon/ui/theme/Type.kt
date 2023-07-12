package com.example.littlelemon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import com.example.littlelemon.R

val KarlaFont = FontFamily(
    Font(R.font.karla_regular, FontWeight.Normal),
    Font(R.font.karla_bold, FontWeight.Bold),
    Font(R.font.karla_extra_bold, FontWeight.ExtraBold),
    Font(R.font.karla_extra_bold, FontWeight.W800),
    Font(R.font.karla_bold, FontWeight.W500),
    Font(R.font.karla_regular, FontWeight.W400),
)

val MarkaziFont = FontFamily(
    Font(R.font.markazitext_regular, FontWeight.W500),
    Font(R.font.markazitext_regular, FontWeight.W400)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = MarkaziFont,
        fontWeight = FontWeight.W500,
        fontSize = 64.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = MarkaziFont,
        fontWeight = FontWeight.W400,
        fontSize = 40.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = KarlaFont, fontWeight = FontWeight.W800, fontSize = 20.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = KarlaFont, fontWeight = FontWeight.ExtraBold, fontSize = 16.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = KarlaFont, fontWeight = FontWeight.Bold, fontSize = 18.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = KarlaFont,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = KarlaFont,
        fontWeight = FontWeight.W400,
        fontSize = 16.sp,
        lineHeight = 16.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = KarlaFont,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
)