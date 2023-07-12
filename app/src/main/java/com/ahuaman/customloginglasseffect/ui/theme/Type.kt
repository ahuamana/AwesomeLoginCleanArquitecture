package com.ahuaman.customloginglasseffect.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ahuaman.customloginglasseffect.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.googlesans_regular),
            Font(R.font.googlesans_medium, FontWeight.Medium),
            Font(R.font.googlesans_bold, FontWeight.Bold),
        ),
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        fontStyle = FontStyle.Normal
    ),

    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.googlesans_bold, FontWeight.Bold)),
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.googlesans_regular),
            Font(R.font.googlesans_medium, FontWeight.Medium),
            Font(R.font.googlesans_bold, FontWeight.Bold)),
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),

    labelMedium = TextStyle(
        fontFamily = FontFamily(
            Font(R.font.googlesans_regular),
            Font(R.font.googlesans_medium, FontWeight.Medium),
            Font(R.font.googlesans_bold, FontWeight.Bold)),
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
)