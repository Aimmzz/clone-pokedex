package com.aimcode.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette
import com.aimcode.designsystem.theme.PokedexTheme

@Composable
internal fun Palette?.paletteBackgroundColor(): State<Color> {
    val defaultBackground = PokedexTheme.colors.background
    return remember(this) {
        derivedStateOf {
            val rgb = this?.dominantSwatch?.rgb
            if (rgb != null) {
                Color(rgb)
            } else {
                defaultBackground
            }
        }
    }
}