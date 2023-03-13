package com.example.notes.core.themes

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightColors = lightColors(
    primary = Red600,
    primaryVariant = Red900,
    onPrimary = Color.White,
    secondary = Red600,
    secondaryVariant = Red100,
    onSecondary = Color.White,
    error = Red800
)

private val DarkColors = darkColors(
    primary = Red300,
    primaryVariant = Red700,
    onPrimary = Color.Black,
    secondary = Red300,
    onSecondary = Color.Black,
    error = Red200,
    secondaryVariant = Gray
)

@Composable
fun LightTheme(content: @Composable () -> Unit,isDark:Boolean) {
    MaterialTheme(
        content = content,
        colors = if(isDark) DarkColors else LightColors
    )
}