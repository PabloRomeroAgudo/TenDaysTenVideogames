package com.example.tendaystenvideogames.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tendaystenvideogames.R

val Roboto = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_bold, FontWeight.Bold)
)

val ProtestGuerrilla = FontFamily(
    Font(R.font.protestguerrilla_regular, FontWeight.Normal)
)

val ProtestRevolution = FontFamily(
    Font(R.font.protestrevolution_regular, FontWeight.Normal)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = ProtestGuerrilla,
        fontWeight = FontWeight.Normal,
        fontSize = 38.sp
    ),
    displayMedium = TextStyle(
        fontFamily = ProtestRevolution,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)