package com.example.productexplorer.theme

import android.app.Activity
import android.hardware.lights.Light
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFFFFFFFF),
    onPrimary = Color(0xFF003826),
    secondary = Color(0xFFF1F1F1),
    background = Color(0xFF1A211B),
    onBackground = Color(0xFFE0E4DF),
    surface = Color(0xFF1C211D),
    tertiary = Color(0xFFA60B46),
    onTertiary = Color.White
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF00231A),
    onPrimary = Color.White,
    secondary = Color(0xFF033629),
    background = Color(0xFFF7FBF6),
    onBackground = Color(0xFF191C1A),
    surface = Color(0xFFFFFFFF),
    tertiary = Color(0xFF960551)
)


private val ProductShapes = Shapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(32.dp),
)

    @Composable
fun ProductExplorerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if(darkTheme){
        DarkColorScheme
    } else {
        LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = ProductTypography,
        shapes = ProductShapes,
        content = content,
    )
}